package bai9_nangcao

import java.io.File

object FileManager {
    // Lưu dữ liệu sinh viên vào file
    fun saveToFile(students: List<Student>, fileName: String) {
        val file = File(fileName)
        file.printWriter().use { out ->
            students.forEach { student ->
                out.println("${student.name}, ${student.email}, ${student.score1}, ${student.score2}, ${student.score3}")
            }
        }
    }

    // Đọc dữ liệu sinh viên từ file
    fun loadFromFile(fileName: String): List<Student> {
        val students = mutableListOf<Student>()
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
        return students
    }
}
