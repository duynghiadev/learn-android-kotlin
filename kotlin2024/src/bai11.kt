fun main() {
    // 1. Dùng với dãy giá trị (range)
    println("1. Dùng với dãy giá trị (range):")
    for (i in 1..5) {  // Lặp từ 1 đến 5 (bao gồm 5)
        println(i)
    }

    // 2. Dùng với bước nhảy (step)
    println("\n2. Dùng với bước nhảy (step):")
    for (i in 1..10 step 2) {  // Lặp từ 1 đến 10, mỗi bước nhảy 2
        println(i)
    }

    // 3. Dùng với lùi (downTo)
    println("\n3. Dùng với lùi (downTo):")
    for (i in 5 downTo 1) {  // Lặp từ 5 đến 1 (bao gồm 1)
        println(i)
    }

    // 4. Dùng với điều kiện không bao gồm giá trị kết thúc (until)
    println("\n4. Dùng với điều kiện không bao gồm giá trị kết thúc (until):")
    for (i in 1 until 5) {  // Lặp từ 1 đến 4 (không bao gồm 5)
        println(i)
    }

    // 5. Dùng với mảng hoặc danh sách
    println("\n5. Dùng với mảng hoặc danh sách:")
    val numbers = arrayOf(1, 2, 3, 4, 5)
    for (number in numbers) {
        println(number)
    }

    val names = listOf("Alice", "Bob", "Charlie")
    for (name in names) {
        println(name)
    }

    // 6. Dùng với chỉ số của mảng hoặc danh sách
    println("\n6. Dùng với chỉ số của mảng hoặc danh sách:")
    val fruits = arrayOf("Apple", "Banana", "Cherry")
    for (index in fruits.indices) {
        println("Fruit at index $index is ${fruits[index]}")
    }

    // 7. Lọc các số lẻ và cộng lại
    println("\n7. Lọc các số lẻ và cộng lại:")
    val numbersToCheck = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var sumOfOddNumbers = 0
    for (number in numbersToCheck) {
        if (number % 2 != 0) {  // Kiểm tra số lẻ
            println("Số lẻ: $number")
            sumOfOddNumbers += number  // Cộng số lẻ vào tổng
        }
    }
    println("Tổng các số lẻ: $sumOfOddNumbers")
}
