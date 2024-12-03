fun main() {
    // Ví dụ 1: Toán tử Logic
    val a = true
    val b = false

    println("a && b: ${a && b}") // false: cả hai phải đúng
    println("a || b: ${a || b}") // true: chỉ cần một đúng
    println("!a: ${!a}")         // false: phủ định của `a`

    // Ngăn cách giữa các phần để dễ đọc
    println("------------")

    // Ví dụ 2: Toán tử Tiền tố và Hậu tố
    var x = 5

    // Toán tử Tiền tố
    println("Tiền tố ++x: ${++x}") // 6: Tăng trước, in ra sau
    println("Tiền tố --x: ${--x}") // 5: Giảm trước, in ra sau

    // Toán tử Hậu tố
    println("Hậu tố x++: ${x++}") // 5: In ra trước, tăng sau
    println("Hậu tố x--: ${x--}") // 6: In ra trước, giảm sau

    println("Giá trị cuối của x: $x") // 5

    // Ngăn cách giữa các phần để dễ đọc
    println("------------")

    // Ví dụ 3: Kết hợp Toán tử Logic và Tiền tố/Hậu tố
    var c = 5
    var d = 3

    val result = (++c > 5 && d-- < 3) || (c++ == 6)
    println("Kết quả: $result")  // true
    println("Giá trị cuối của c: $c") // 7
    println("Giá trị cuối của d: $d") // 2
}
