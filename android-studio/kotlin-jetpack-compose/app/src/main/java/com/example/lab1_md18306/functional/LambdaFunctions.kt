package com.example.lab1_md18306.functional

data class SinhVien1(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daToNghiep: Boolean?,
    var tuoi: Int?
)

class LambdaFunctions {

    private val danhSachSinhVien = mutableListOf<SinhVien1>()

    val timSinhVien: (String) -> SinhVien1? = { mssv ->
        danhSachSinhVien.find { it.mssv == mssv }
    }

    fun themSinhVien() {
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

        danhSachSinhVien.add(SinhVien1(tenSV, mssv, diemTB, daToNghiep, tuoi))
        println("Thêm sinh viên thành công!")
    }

    fun xemSinhVien() {
        print("Nhập MSSV của sinh viên cần tìm: ")
        val mssv = readLine()?.trim()
        val sinhVien = timSinhVien(mssv ?: "")
        if (sinhVien != null) {
            println("Thông tin sinh viên: $sinhVien")
        } else {
            println("Không tìm thấy sinh viên với MSSV: $mssv")
        }
    }
}

fun main() {
    val lambdaFunctions = LambdaFunctions()
    while (true) {
        println("\n=== Menu ===")
        println("1. Thêm sinh viên")
        println("2. Xem sinh viên")
        println("3. Thoát")
        print("Chọn chức năng: ")

        when (readLine()?.toIntOrNull()) {
            1 -> lambdaFunctions.themSinhVien()
            2 -> lambdaFunctions.xemSinhVien()
            3 -> {
                println("Tạm biệt!")
                return
            }

            else -> println("Lựa chọn không hợp lệ, vui lòng thử lại.")
        }
    }
}
