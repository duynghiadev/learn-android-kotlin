fun main() {
    // Biểu thức chính quy kiểm tra email hợp lệ (phải có đuôi tên miền hợp lệ như .com, .net, .co...)
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    // Biểu thức chính quy kiểm tra điểm hợp lệ (chỉ chứa số và có thể có một dấu chấm thập phân)
    val scoreRegex = "^[0-9]?(\\.[0-9]{1,2})?\$".toRegex()

    println("Nhập số lượng sinh viên:")
    val numberOfStudents = readLine()?.toIntOrNull() ?: 0

    for (i in 1..numberOfStudents) {
        println("\nNhập thông tin sinh viên thứ $i:")

        // Nhập tên sinh viên
        print("Tên sinh viên: ")
        val name = readLine()?.trim()

        // Kiểm tra tên không được rỗng
        if (name.isNullOrBlank()) {
            println("Tên sinh viên không hợp lệ!")
            continue
        }

        var email: String?
        do {
            // Nhập email và kiểm tra tính hợp lệ
            print("Email sinh viên: ")
            email = readLine()?.trim()

            if (email == null || !email.matches(emailRegex)) {
                println("Email không hợp lệ! Vui lòng nhập lại.")
            }
        } while (email == null || !email.matches(emailRegex)) // Lặp lại nếu email không hợp lệ

        // Nhập điểm các môn học
        print("Nhập điểm môn 1: ")
        val score1 = readLine()?.trim()
        print("Nhập điểm môn 2: ")
        val score2 = readLine()?.trim()
        print("Nhập điểm môn 3: ")
        val score3 = readLine()?.trim()

        // Kiểm tra điểm hợp lệ
        if (!isValidScore1(score1) || !isValidScore1(score2) || !isValidScore1(score3)) {
            println("Điểm không hợp lệ, vui lòng nhập lại.")
            continue
        }

        // Chuyển đổi điểm từ String sang Double
        val score1Double = score1?.toDoubleOrNull() ?: 0.0
        val score2Double = score2?.toDoubleOrNull() ?: 0.0
        val score3Double = score3?.toDoubleOrNull() ?: 0.0

        // Kiểm tra các điểm có hợp lệ không (từ 0 đến 10)
        if (score1Double !in 0.0..10.0 || score2Double !in 0.0..10.0 || score3Double !in 0.0..10.0) {
            println("Điểm phải trong khoảng từ 0 đến 10.")
            continue
        }

        // Tính điểm trung bình
        val averageScore = (score1Double + score2Double + score3Double) / 3
        val result = if (averageScore >= 5.0) "Đậu" else "Rớt"

        // In kết quả
        println("\nThông tin sinh viên:")
        println("Tên: $name")
        println("Email: $email")
        println("Điểm trung bình: $averageScore")
        println("Kết quả: $result")
    }
}

// Hàm kiểm tra xem điểm có hợp lệ không
fun isValidScore1(score: String?): Boolean {
    return score != null && score.matches("^[0-9]?(\\.[0-9]{1,2})?\$".toRegex())
}
