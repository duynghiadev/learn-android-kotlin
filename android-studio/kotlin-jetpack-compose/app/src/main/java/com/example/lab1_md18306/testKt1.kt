package com.example.lab1_md18306

fun main() {
    // when trong kotlin -> có nghĩa là switch case
    cases("Hello")
    cases(1)
    cases(0L)
    cases("hello")
    println("----------------------------------------")

    var a = 0.0
    var b = 0.0
    println("Nhap a: ")
    var s = readlnOrNull()
    if (s != null) a = s.toDouble()
    println("Nhap b: ")
    s = readlnOrNull()
    if (s != null) b = s.toDouble()
    println("Tong a + b = ${a + b}")
    println("Hieu a - b = ${a - b}")
    println("Tich a * b = ${a * b}")
    println("Thuong a / b = ${a / b}")
    println("----------------------------------------")
}

fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

class testKt1 {
}