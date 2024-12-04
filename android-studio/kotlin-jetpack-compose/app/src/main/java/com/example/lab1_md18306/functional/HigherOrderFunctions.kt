package com.example.lab1_md18306.functional

// Dữ liệu của SinhVien
data class SinhVien(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daToNghiep: Boolean?,
    var tuoi: Int?
)

class HigherOrderFunctions {

    private val danhSachSinhVien = mutableListOf<SinhVien>()

    // Higher-order function: Thực hiện hành động với một sinh viên được nhập từ terminal
    fun withStudentAction(action: (SinhVien) -> Unit) {
        println("\n=== Nhập thông tin sinh viên ===")
        print("Tên sinh viên: ")
        val tenSV = readLine()?.trim() ?: "Unknown"
        print("MSSV: ")
        val mssv = readLine()?.trim() ?: "00000"
        print("Điểm trung bình: ")
        val diemTB = readLine()?.toFloatOrNull() ?: 0.0f
        print("Đã tốt nghiệp? (true/false): ")
        val daToNghiep = readLine()?.toBooleanStrictOrNull()
        print("Tuổi: ")
        val tuoi = readLine()?.toIntOrNull()

        val sinhVien = SinhVien(tenSV, mssv, diemTB, daToNghiep, tuoi)
        action(sinhVien)
    }

    fun themSinhVien() {
        withStudentAction { sinhVien ->
            danhSachSinhVien.add(sinhVien)
            println("Sinh viên ${sinhVien.tenSV} đã được thêm vào danh sách.")
        }
    }

    fun xemDanhSachSinhVien() {
        println("\n=== Danh sách sinh viên ===")
        if (danhSachSinhVien.isEmpty()) {
            println("Danh sách trống.")
            return
        }
        danhSachSinhVien.forEachIndexed { index, sv ->
            println("${index + 1}. $sv")
        }
    }
}

fun main() {
    val higherOrderFunctions = HigherOrderFunctions()
    while (true) {
        println("\n=== Menu ===")
        println("1. Thêm sinh viên")
        println("2. Xem danh sách sinh viên")
        println("3. Thoát")
        print("Chọn chức năng: ")

        when (readLine()?.toIntOrNull()) {
            1 -> higherOrderFunctions.themSinhVien()
            2 -> higherOrderFunctions.xemDanhSachSinhVien()
            3 -> {
                println("Tạm biệt!")
                return
            }

            else -> println("Lựa chọn không hợp lệ, vui lòng thử lại.")
        }
    }
}
