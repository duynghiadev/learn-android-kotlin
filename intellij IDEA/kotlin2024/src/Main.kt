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

    println("==================================================================")

    /*
    * - Ép kiểu trong kotlin
    * - ép từ kiểu dữ liệu nhỏ sang kiểu dữ liệu lớn
    * byte < short or int < long
    * */
//    ép từ nhỏ sang lớn
    var a: Int = 9
    var a1: Long = a.toLong()
    println("a = $a có kiểu dữ liệu là: " + a::class.java.typeName)
    println("a1 = $a1 có kiểu dữ liệu là: " + a1::class.java.typeName)

//    ép từ lớn xuống nhỏ
//    byte < short
    var x: Short = 3456 // leak memmory
    var y: Byte = x.toByte()
    println("x = $x có kiểu dữ liệu là: " + x::class.java.typeName)
    println("y = $y có kiểu dữ liệu là: " + y::class.java.typeName)

    println("==================================================================")

    var x1: Short = 125
    var y1: Byte = x1.toByte()
    println("x1 = $x1 có kiểu dữ liệu là: " + x1::class.java.typeName)
    println("y1 = $y1 có kiểu dữ liệu là: " + y1::class.java.typeName)

    println("==================================================================")
    println("Toán tử trong Kotlin")
    println("==================================================================")

    var x2: Int = 20
    var x3 = 3
    println("x2 = $x2 có kiểu dữ liệu là: " + x2::class.java.typeName)
    println("x3 = $x3 có kiểu dữ liệu là: " + x3::class.java.typeName)

    println("x2 + x3: " + (x2 + x3))
    println("x2 - x3: " + (x2 - x3))
    println("x2 * x3: " + (x2 * x3))
    println("x2 / x3: " + (x2 / x3))
    println("x2 % x3: " + (x2 % x3))

    println("==================================================================")
    println("Toán tử gán trong Kotlin")
    println("==================================================================")

    // cộng bằng: +=
    // trừ bằng: -=
    // nhân bằng: *=
    // chia bằng: /=
    // chia lấy dư bằng: %=

    var x4 = 20
    x4 += 5
    println("x4 = $x4")

    x4 -= 5
    println("x4 = $x4")

    x4 *= 5
    println("x4 = $x4")

    x4 %= 5
    println("x4 = $x4")

    println("==================================================================")
    println("Toán so sánh trong Kotlin")
    println("==================================================================")

    var x5 = 90
    var x6 = 7

    println("x5 > x6: " + (x5 > x6))
    println("x5 < x6: " + (x5 < x6))
}