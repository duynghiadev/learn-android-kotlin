package com.example.lab1_md18306

fun main() {
    println("Hello Kotlin - bai 1")
    println("---------------------------")

    // khai báo và sử dụng biến
    val a = 1
    val b = 2
    var c = a + b
    println("a = $a, b = $b, a+b = $c")

    val mess: String = "Tổng 2 số $a và $b là $c"
    println("mess: $mess")

    val soA = 1
    val soB = 3f
    val ketQua = phepChia(soA, soB)
    print("Kết quả: $ketQua")
    println("\n---------------------------")

    // khai báo và sử dụng mảng
    val arrX = intArrayOf(1, 2, 3, 4)
    val arrY = arrayOf(1.5f, "A", 3)
    println("arrX: ${arrX.contentToString()}")
    println("Giá trị đầu tiên của mảng X: ${arrX[0]}")
    println("arrY: ${arrY.contentToString()}")
    println("Giá trị đầu tiên của mảng Y: ${arrY[0]}")
}

fun phepChia(soA: Int, soB: Float): String {
    if (soB == 0f) {
        return "Số B không được bằng 0"
    }

    val thuong = soA / soB
    return "Thương 2 số  $soA và $soB = $thuong"
}

class lab1 {
}