package bai9_nangcao

import java.io.File

fun main() {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
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
        Menu.display()

        when (readLine()?.toIntOrNull()) {
            1 -> {
                if (students.isEmpty()) {
                    println("Chưa có sinh viên nào. Vui lòng nhập thông tin sinh viên trước.")
                } else {
                    print("Bạn có muốn sửa điểm của sinh viên không? (y/n): ")
                    if (readLine()?.lowercase() == "y") {
                        println("\nDanh sách tên sinh viên và điểm:")
                        students.forEachIndexed { index, student ->
                            println("${index + 1}. Tên: ${student.name} - Điểm môn 1: ${student.score1} - Điểm môn 2: ${student.score2} - Điểm môn 3: ${student.score3}")
                        }

                        print("Nhập số thứ tự sinh viên muốn sửa: ")
                        val studentIndex = readLine()?.toIntOrNull()?.minus(1)

                        if (studentIndex != null && studentIndex in students.indices) {
                            val student = students[studentIndex]
                            println("\nThông tin sinh viên bạn muốn sửa: Tên: ${student.name}, Điểm môn 1: ${student.score1}, Điểm môn 2: ${student.score2}, Điểm môn 3: ${student.score3}")

                            print("Bạn có muốn sửa tên sinh viên? (y/n): ")
                            if (readLine()?.lowercase() == "y") {
                                print("Nhập tên mới: ")
                                val newName = readLine()?.trim()
                                if (!newName.isNullOrBlank()) {
                                    students[studentIndex] = student.copy(name = newName)
                                    println("Tên sinh viên đã được sửa thành công.")
                                }
                            }

                            print("Bạn có muốn sửa điểm của sinh viên này? (y/n): ")
                            if (readLine()?.lowercase() == "y") {
                                val newScores = mutableListOf<Double>()
                                for (i in 1..3) {
                                    var newScore: Double
                                    do {
                                        print("Nhập điểm môn $i (từ 0 đến 10): ")
                                        newScore = readLine()?.toDoubleOrNull() ?: -1.0
                                        if (newScore !in 0.0..10.0) {
                                            println("Điểm bạn nhập không hợp lệ, vui lòng nhập lại.")
                                        }
                                    } while (newScore !in 0.0..10.0)
                                    newScores.add(newScore)
                                }

                                students[studentIndex] =
                                    student.copy(score1 = newScores[0], score2 = newScores[1], score3 = newScores[2])
                                println("Điểm sinh viên đã được sửa thành công.")
                            }

                            saveToFile(students, fileName)
                            println("Thông tin sinh viên đã được cập nhật thành công.")
                        } else {
                            println("Sinh viên không hợp lệ.")
                        }
                    } else {
                        println("Quay lại menu chính.")
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
                println("\nNhập thông tin sinh viên mới:")
                print("Tên sinh viên: ")
                val name = readLine()?.trim()
                if (name.isNullOrBlank()) {
                    println("Tên sinh viên không hợp lệ!")
                    continue
                }

                var email: String?
                do {
                    print("Email sinh viên: ")
                    email = readLine()?.trim()
                    if (email == null || !email.matches(emailRegex)) {
                        println("Email không hợp lệ! Vui lòng nhập lại.")
                    }
                } while (email == null || !email.matches(emailRegex))

                val newScores = mutableListOf<Double>()
                for (i in 1..3) {
                    var newScore: Double
                    do {
                        print("Nhập điểm môn $i (từ 0 đến 10): ")
                        newScore = readLine()?.toDoubleOrNull() ?: -1.0
                        if (newScore !in 0.0..10.0) {
                            println("Điểm bạn nhập không hợp lệ, vui lòng nhập lại.")
                        }
                    } while (newScore !in 0.0..10.0)
                    newScores.add(newScore)
                }

                val newStudent = Student(name, email, newScores[0], newScores[1], newScores[2])
                students.add(newStudent)
                saveToFile(students, fileName)

                println("Thông tin sinh viên đã được lưu thành công.")
            }

            5 -> {
                if (students.isEmpty()) {
                    println("Chưa có sinh viên nào. Vui lòng nhập thông tin sinh viên trước.")
                } else {
                    println("\nDanh sách tất cả sinh viên (Tên, điểm từng môn, đậu/rớt):")
                    printTableHeader()
                    students.forEachIndexed { index, student ->
                        printTableRow(index + 1, student)
                    }
                }
            }

            6 -> {
                println("Cảm ơn bạn đã sử dụng chương trình!")
                break
            }

            else -> println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
        }
    }
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

// In tiêu đề bảng
fun printTableHeader() {
    println("+----+------------------+------------+------------+------------+------------+")
    println("| STT| Tên sinh viên    | Điểm môn 1 | Điểm môn 2 | Điểm môn 3 | Kết quả    |")
    println("+----+------------------+------------+------------+------------+------------+")
}

// In dòng thông tin sinh viên
fun printTableRow(index: Int, student: Student) {
    println(
        "| %-2s | %-16s | %-10.2f | %-10.2f | %-10.2f | %-10s |".format(
            index,
            student.name,
            student.score1,
            student.score2,
            student.score3,
            student.result()
        )
    )
    println("+----+------------------+------------+------------+------------+------------+")
}
