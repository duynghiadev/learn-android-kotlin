fun main() {
    // this is a comment -> one line

    /*
    * comment multiple lines
    */

    val name: String = "Kotlin" // this is a constant -> no change
    var name1: String = "duynghia" // this is a variable -> can change

//    name = "Ronaldo" // error
    name1 = "Messi" // no error

    println("Hello, $name!")
    println("Hello, $name1!")

//    convenient variable name
    var nameProduct: String = "computer"
    println("nameProduct: $nameProduct")

//    kiểu số nguyên
    var b: Byte = 127
    println("Kieu du lieu cua $b la: " + (b::class.java.typeName))

//    khai báo mảng số nguyên
    var arrayNumber: IntArray = intArrayOf(34, 21, 23, 14)
    println("arrayNumber: " + arrayNumber.contentToString())

//    khai báo mảng số thực
    var arrayFloat: FloatArray = floatArrayOf(34.5F, 234.5F, 234.5F)
    println("arrayFloat: " + arrayFloat.contentToString())

//    khai báo mảng string
    println("Phần tử thứ nhất trong arrayNumber là ${arrayNumber[0]}")

    for (i in 1..5) {
        println("i = $i")
    }
}