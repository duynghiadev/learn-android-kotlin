fun main() {
    // Nhập dữ liệu từ bàn phím
    val scanner = java.util.Scanner(System.`in`)

    println("Nhập giá trị đầu tiên (x): ")
    var x = scanner.nextInt() // Người dùng nhập giá trị cho x

    println("Nhập giá trị đầu tiên (y): ")
    var y = scanner.nextInt() // Người dùng nhập giá trị cho y

    // Ví dụ 1: Toán tử Logic
    val a = (x > 0)
    val b = (y > 0)

    println("x > 0 && y > 0: ${a && b}") // true nếu cả hai lớn hơn 0
    println("x > 0 || y > 0: ${a || b}") // true nếu ít nhất một lớn hơn 0
    println("!(x > 0): ${!a}")           // true nếu x không lớn hơn 0

    // Ngăn cách giữa các phần để dễ đọc
    println("------------")

    // Ví dụ 2: Toán tử Tiền tố và Hậu tố
    println("Tiền tố ++x: ${++x}") // Tăng giá trị x trước khi sử dụng
    println("Tiền tố --y: ${--y}") // Giảm giá trị y trước khi sử dụng

    println("Hậu tố x++: ${x++}") // Sử dụng giá trị x rồi tăng
    println("Hậu tố y--: ${y--}") // Sử dụng giá trị y rồi giảm

    println("Giá trị cuối của x: $x") // In giá trị cuối của x
    println("Giá trị cuối của y: $y") // In giá trị cuối của y

    // Ngăn cách giữa các phần để dễ đọc
    println("------------")

    // Ví dụ 3: Kết hợp Toán tử Logic và Tiền tố/Hậu tố
    val result = (++x > 5 && y-- < 3) || (x++ == 6)
    println("Kết quả: $result")  // Tùy thuộc vào x, y nhập từ bàn phím
    println("Giá trị cuối của x: $x") // Sau khi tính toán
    println("Giá trị cuối của y: $y") // Sau khi tính toán
}
