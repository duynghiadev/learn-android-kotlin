const { Fruits } = require("../models");
const cloudinary = require("../utils/cloudinary");
// Create Fruit
exports.createFruit = async (req, res) => {
  // console.log(req.body);
  const data = req.body;
  console.log(req.files);
  if (
    data.name &&
    data.quantity &&
    data.price &&
    data.status &&
    data.description &&
    data.distributor
  ) {
    console.log(data);
    try {
      const images = [];
      for (const file of req.files) {
        try {
          const result = await cloudinary.uploader.upload(file.path, {
            folder: "fruits",
          });
          images.push({
            public_id: result.public_id,
            url: result.secure_url,
          });
        } catch (error) {
          console.error(`Failed to upload image: ${error}`);
          return res.status(500).json({ message: "Image upload failed" });
        }
      }
      data.image = images;
      const fruit = new Fruits(data);
      await fruit.save();
      const populatedFruit = await Fruits.findById(fruit._id).populate(
        "distributor"
      );
      res.status(200).json(populatedFruit);
    } catch (error) {
      console.log(error);
      res.status(500).json(error);
    }
  } else {
    res.status(400).json({
      message: "Bad Request, missing parameters",
    });
  }
};

// Get Fruits// Get Fruits
exports.getFruits = async (req, res) => {
  const page = req.query.page || 1;
  const limit = req.query.limit || 10;
  const skip = (page - 1) * limit;
  const order = req.query.order || "desc";
  const sortBy = req.query.sortBy || "createdAt";
  try {
    const fruits = await Fruits.find()
      .skip(skip)
      .limit(limit)
      .sort({ [sortBy]: order })
      .populate("distributor");
    res.status(200).json(fruits);
  } catch (error) {
    res.status(500).json(error);
  }
};

// Get Fruit by ID
exports.getFruitById = async (req, res) => {
  const fruitId = req.params.fruitId;
  if (fruitId) {
    try {
      const fruit = await Fruits.findById(fruitId).populate("distributor");
      if (fruit) {
        res.status(200).json(fruit);
      } else {
        res.status(404).json({
          message: "Fruit not found",
        });
      }
    } catch (error) {
      res.status(500).json(error);
    }
  } else {
    res.status(400).json({
      message: "Bad Request, missing parameters",
    });
  }
};

// Update Fruit by ID
exports.updateFruit = async (req, res) => {
  const fruitId = req.params.fruitId;
  if (fruitId) {
    try {
      const fruit = await Fruits.findById(fruitId).populate("distributor");
      if (fruit) {
        let images = fruit.image;

        // Check if new images are uploaded
        if (req.files && req.files.length > 0) {
          // Delete old images from Cloudinary
          for (const oldImage of images) {
            await cloudinary.uploader.destroy(oldImage.public_id);
          }

          // Upload new images to Cloudinary and replace the images array
          images = [];
          for (const file of req.files) {
            try {
              // Upload new image to Cloudinary
              const result = await cloudinary.uploader.upload(file.path, {
                folder: "fruits",
              });
              images.push({
                public_id: result.public_id,
                url: result.secure_url,
              });
            } catch (error) {
              console.error(`Failed to upload image: ${error}`);
              return res.status(500).json({ message: "Image upload failed" });
            }
          }
        }

        // Update other fields if provided
        if (req.body.name) fruit.name = req.body.name;
        if (req.body.quantity) fruit.quantity = req.body.quantity;
        if (req.body.price) fruit.price = req.body.price;
        if (req.body.status) fruit.status = req.body.status;
        if (req.body.description) fruit.description = req.body.description;
        if (req.body.distributor) fruit.distributor = req.body.distributor;

        // Update fruit with new or existing images
        fruit.image = images;
        await fruit.save();

        res.status(200).json(fruit);
      } else {
        res.status(404).json({ message: "Fruit not found" });
      }
    } catch (error) {
      console.log(error);
      res.status(500).json(error);
    }
  } else {
    res.status(400).json({ message: "Bad Request, missing parameters" });
  }
};
// Delete Fruit by ID
exports.deleteFruit = async (req, res) => {
  const fruitId = req.params.fruitId;
  if (fruitId) {
    try {
      const fruit = await Fruits.findById(fruitId).populate("distributor");

      //delete image from cloudinary
      for (const image of fruit.image) {
        console.log(image.public_id);
        try {
          await cloudinary.uploader.destroy(image.public_id);
          console.log("Image deleted");
        } catch (error) {
          console.error(`Failed to delete image: ${error}`);
        }
      }

      if (fruit) {
        // Use findByIdAndRemove to delete the fruit
        const deletedFruit = await Fruits.findByIdAndDelete(fruitId).populate(
          "distributor"
        );
        if (deletedFruit) {
          res.status(200).json(deletedFruit);
        } else {
          res.status(404).json({
            message: "Fruit not found",
          });
        }
      } else {
        res.status(404).json({
          message: "Fruit not found",
        });
      }
    } catch (error) {
      console.log(error);
      res.status(500).json(error);
    }
  } else {
    res.status(400).json({
      message: "Bad Request, missing parameters",
    });
  }
};

// Search Fruits
exports.searchFruits = async (req, res) => {
  const query = req.query.name;
  if (query) {
    try {
      const fruits = await Fruits.find({
        name: { $regex: query, $options: "i" },
      }).populate("distributor");
      if (fruits.length > 0) {
        res.status(200).json(fruits);
      } else {
        res.status(404).json({
          message: "Fruit not found",
        });
      }
    } catch (error) {
      res.status(500).json(error);
    }
  } else {
    res.status(400).json({
      message: "Bad Request, missing parameters",
    });
  }
};

// Get fruit using query params
exports.getFruitByQuery = async (req, res) => {
  let perPage = 6;
  let page = req.query.page || 1;
  let skip = perPage * page - perPage;
  let count = await Fruits.find().countDocuments();

  const name = { $regex: req.query.name ?? "", $options: "i" };

  const price = { $gte: req.query.price ?? 0 };

  const sort = { price: req.query.sort ?? 1 };

  try {
    const fruits = await Fruits.find({ name, price })
      .skip(skip)
      .limit(perPage)
      .sort(sort)
      .populate("distributor");

    res.status(200).json({
      fruits,
      page,
      pages: Math.ceil(count / perPage),
      perPage,
      count,
    });
    console.log(fruits);
    console.log(count);
  } catch (error) {
    res.status(500).json(error);
    console.log(error);
  }
};
