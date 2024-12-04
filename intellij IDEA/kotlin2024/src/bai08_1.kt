fun main() {
    // Ví dụ 4: Sử dụng matches và toRegex
    println("Nhập một chuỗi để kiểm tra (ví dụ: email, số điện thoại):")
    val inputString = readLine() ?: ""

    // Biểu thức chính quy để kiểm tra một email hợp lệ
    val emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()

    // Kiểm tra email trước
    if (inputString.matches(emailRegex)) {
        println("Đây là một email hợp lệ!")
    } else {
        // Kiểm tra số điện thoại nếu không phải email
        val phoneRegex = "^0[1-9]{1}[0-9]{8}$".toRegex()

        if (inputString.matches(phoneRegex)) {
            println("Đây là một số điện thoại hợp lệ!")
        } else {
            println("Đây không phải là một email hay số điện thoại hợp lệ!")
        }
    }
}
