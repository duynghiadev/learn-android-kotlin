import java.io.File

data class Student(val name: String, val email: String, val score1: Double, val score2: Double, val score3: Double) {
    fun averageScore(): Double = (score1 + score2 + score3) / 3
    fun result(): String = if (averageScore() >= 5.0) "Đậu" else "Rớt"
}

fun main() {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    val scoreRegex = "^[0-9]?(\\.[0-9]{1,2})?\$".toRegex()
    val students = mutableListOf<Student>()

    // Đọc dữ liệu từ file nếu có
    val fileName = "students.txt"
    val file = File(fileName)
    if (file.exists()) {
        file.readLines().forEach {
            val parts = it.split(", ")
            val name = parts[0]
            val email = parts[1]
            val score1 = parts[2].toDouble()
            val score2 = parts[3].toDouble()
            val score3 = parts[4].toDouble()
            students.add(Student(name, email, score1, score2, score3))
        }
    }

    while (true) {
        // Menu
        println("\n===============================")
        println("Chọn một lựa chọn:")
        println("1. Xem điểm của sinh viên")
        println("2. Xem tên của sinh viên")
        println("3. Xem sinh viên đậu/rớt")
        println("4. Nhập thông tin sinh viên mới")
        println("5. Thoát")
        print("Nhập lựa chọn của bạn: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                if (students.isEmpty()) {
                    println("Chưa có sinh viên nào. Vui lòng nhập thông tin sinh viên trước.")
                } else {
                    println("\nDanh sách điểm của sinh viên:")
                    students.forEachIndexed { index, student ->
                        println("Sinh viên ${index + 1}: Tên ${student.name} - Điểm ${student.averageScore()}")
                    }
                }
            }

            2 -> {
                if (students.isEmpty()) {
                    println("Chưa có sinh viên nào. Vui lòng nhập thông tin sinh viên trước.")
                } else {
                    println("\nDanh sách tên sinh viên:")
                    students.forEachIndexed { index, student ->
                        println("Sinh viên ${index + 1}: ${student.name}")
                    }
                }
            }

            3 -> {
                if (students.isEmpty()) {
                    println("Chưa có sinh viên nào. Vui lòng nhập thông tin sinh viên trước.")
                } else {
                    println("\nDanh sách sinh viên đậu/rớt:")
                    students.forEachIndexed { index, student ->
                        println("Sinh viên ${index + 1}: ${student.name} - ${student.result()}")
                    }
                }
            }

            4 -> {
                // Nhập thông tin sinh viên mới
                println("\nNhập thông tin sinh viên mới:")

                // Nhập tên sinh viên
                print("Tên sinh viên: ")
                val name = readLine()?.trim()
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

                // Nhập điểm các môn học và kiểm tra điểm hợp lệ
                var score1: String?
                var score2: String?
                var score3: String?
                do {
                    print("Nhập điểm môn 1: ")
                    score1 = readLine()?.trim()
                } while (!isValidScore2(score1)) // Yêu cầu nhập lại nếu điểm không hợp lệ

                do {
                    print("Nhập điểm môn 2: ")
                    score2 = readLine()?.trim()
                } while (!isValidScore2(score2)) // Yêu cầu nhập lại nếu điểm không hợp lệ

                do {
                    print("Nhập điểm môn 3: ")
                    score3 = readLine()?.trim()
                } while (!isValidScore2(score3)) // Yêu cầu nhập lại nếu điểm không hợp lệ

                // Chuyển đổi điểm từ String sang Double
                val score1Double = score1?.toDoubleOrNull() ?: 0.0
                val score2Double = score2?.toDoubleOrNull() ?: 0.0
                val score3Double = score3?.toDoubleOrNull() ?: 0.0

                // Kiểm tra các điểm có hợp lệ không (từ 0 đến 10)
                if (score1Double !in 0.0..10.0 || score2Double !in 0.0..10.0 || score3Double !in 0.0..10.0) {
                    println("Điểm phải trong khoảng từ 0 đến 10.")
                    continue
                }

                // Lưu thông tin sinh viên vào danh sách và file
                val newStudent = Student(name, email, score1Double, score2Double, score3Double)
                students.add(newStudent)
                saveToFile(students, fileName)

                println("Thông tin sinh viên đã được lưu thành công.")
            }

            5 -> {
                println("Cảm ơn bạn đã sử dụng chương trình!")
                break
            }

            else -> println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
        }
    }
}

// Hàm kiểm tra xem điểm có hợp lệ không
fun isValidScore2(score: String?): Boolean {
    return score != null && score.matches("^[0-9]?(\\.[0-9]{1,2})?\$".toRegex())
}

// Lưu dữ liệu sinh viên vào file
fun saveToFile(students: List<Student>, fileName: String) {
    val file = File(fileName)
    file.printWriter().use { out ->
        students.forEach { student ->
            out.println("${student.name}, ${student.email}, ${student.score1}, ${student.score2}, ${student.score3}")
        }
    }
}
