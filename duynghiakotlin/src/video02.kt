fun main() {
    var n = getNFromKeyboard_1()
    var binaryResult1 = convert_1(n, 2)
    var hexaResult1 = convert_1(n, 16)
    println("binaryResult1 = $binaryResult1")
    println("hexaResult1 = $hexaResult1")
}

fun convert_1(n: Int, base: Int): Any {
    val ref: String = "0123456789ABCDEF"
    var currN = n
    var result = ""
    while (currN > 0) {
        var remainder = currN % base
        result += ref.get(remainder)
        currN /= base
    }
    return result.reversed()
}

fun getNFromKeyboard_1(): Int {
    var n: Int
    while (true) {
        println("Nhập vào 1 số nguyên dương có 2 đến 6 chữ số: ")
        n = readLine()!!.toInt()
        if (n > 9 && n <= 999999) {
            break
        }
    }
    return n
}
