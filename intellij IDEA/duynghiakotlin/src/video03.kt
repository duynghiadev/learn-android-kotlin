fun main() {
    var n: Int
    var k: Int
    n = getNFromKeyboard_2()
    k = getKFromKeyboard_2(n)
    var result = (n / k) * k
    println("result = $result")
}

private fun getKFromKeyboard_2(n: Int): Int {
    var k: Int
    while (true) {
        println("Nhập số nguyên dương k < n: ")
        k = readln().toInt()
        if (k > 0 && k < n) {
            break
        }
    }
    return k
}

private fun getNFromKeyboard_2(): Int {
    var n: Int
    while (true) {
        println("Nhập số nguyên dương n: ")
        n = readln().toInt()
        if (n > 0) {
            break;
        }
    }
    return n
}
