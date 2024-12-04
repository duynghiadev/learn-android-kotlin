package com.example.lab1_md18306.functional

data class SinhVien2(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daToNghiep: Boolean?,
    var tuoi: Int?
)

class ExtensionFunctionsAndProperties {

    private val danhSachSinhVien = mutableListOf<SinhVien2>()

    fun SinhVien2.hienThiThongTin() {
        println("Tên: $tenSV, MSSV: $mssv, Điểm TB: $diemTB, Tốt nghiệp: ${daToNghiep ?: "Chưa rõ"}, Tuổi: $tuoi")
    }

    val SinhVien2.diemTBFormatted: String
        get() = "%.2f".format(diemTB)

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

        danhSachSinhVien.add(SinhVien2(tenSV, mssv, diemTB, daToNghiep, tuoi))
        println("Thêm sinh viên thành công!")
    }

    fun xemDanhSachSinhVien() {
        println("\n=== Danh sách sinh viên ===")
        if (danhSachSinhVien.isEmpty()) {
            println("Danh sách trống.")
            return
        }
        danhSachSinhVien.forEach { it.hienThiThongTin() }
    }

    fun xemDiemSinhVien() {
        println("\n=== Điểm trung bình của sinh viên ===")
        danhSachSinhVien.forEach { println("Sinh viên: ${it.tenSV}, Điểm TB: ${it.diemTBFormatted}") }
    }
}

fun main() {
    val extensionFunctions = ExtensionFunctionsAndProperties()
    while (true) {
        println("\n=== Menu ===")
        println("1. Thêm sinh viên")
        println("2. Xem danh sách sinh viên")
        println("3. Xem điểm sinh viên")
        println("4. Thoát")
        print("Chọn chức năng: ")

        when (readLine()?.toIntOrNull()) {
            1 -> extensionFunctions.themSinhVien()
            2 -> extensionFunctions.xemDanhSachSinhVien()
            3 -> extensionFunctions.xemDiemSinhVien()
            4 -> {
                println("Tạm biệt!")
                return
            }

            else -> println("Lựa chọn không hợp lệ, vui lòng thử lại.")
        }
    }
}
