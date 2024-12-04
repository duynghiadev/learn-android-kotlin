package com.example.lab1_md18306.scope_function

data class SinhVien(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daToNghiep: Boolean? = null,
    var tuoi: Int? = null
)

class ScopeFunctions {
    private val danhSachSinhVien = mutableListOf<SinhVien>()

    fun run() {
        while (true) {
            println("\n=== Quản lý sinh viên với Scope Functions ===")
            println("1. Thêm sinh viên (apply)")
            println("2. Xem chi tiết sinh viên (let)")
            println("3. Tìm và sửa thông tin sinh viên (run)")
            println("4. Hiển thị danh sách sinh viên (with)")
            println("5. Xóa sinh viên (also)")
            println("6. Thoát")
            print("Nhập lựa chọn của bạn: ")

            when (readLine()?.toIntOrNull()) {
                1 -> themSinhVien()
                2 -> xemChiTietSinhVien()
                3 -> suaThongTinSinhVien()
                4 -> hienThiDanhSach()
                5 -> xoaSinhVien()
                6 -> {
                    println("Cảm ơn bạn đã sử dụng chương trình!")
                    return
                }

                else -> println("Lựa chọn không hợp lệ, vui lòng thử lại.")
            }
        }
    }

    private fun themSinhVien() {
        println("\n=== Thêm sinh viên ===")
        val sinhVien = SinhVien("", "", 0.0f).apply {
            print("Nhập tên sinh viên: ")
            tenSV = readLine()?.trim() ?: ""
            print("Nhập MSSV: ")
            mssv = readLine()?.trim() ?: ""
            print("Nhập điểm trung bình: ")
            diemTB = readLine()?.toFloatOrNull() ?: 0.0f
            print("Sinh viên đã tốt nghiệp? (true/false): ")
            daToNghiep = readLine()?.toBooleanStrictOrNull()
            print("Nhập tuổi: ")
            tuoi = readLine()?.toIntOrNull()
        }
        danhSachSinhVien.add(sinhVien)
        println("Thêm sinh viên thành công!")
    }

    private fun xemChiTietSinhVien() {
        println("\n=== Xem chi tiết sinh viên ===")
        print("Nhập MSSV của sinh viên: ")
        val mssv = readLine()?.trim()
        val sinhVien = danhSachSinhVien.find { it.mssv == mssv }

        sinhVien?.let {
            println("Thông tin sinh viên:")
            println("Tên: ${it.tenSV}")
            println("MSSV: ${it.mssv}")
            println("Điểm trung bình: ${it.diemTB}")
            println("Đã tốt nghiệp: ${it.daToNghiep}")
            println("Tuổi: ${it.tuoi}")
        } ?: println("Không tìm thấy sinh viên với MSSV: $mssv")
    }

    private fun suaThongTinSinhVien() {
        println("\n=== Sửa thông tin sinh viên ===")
        print("Nhập MSSV của sinh viên cần sửa: ")
        val mssv = readLine()?.trim()
        val sinhVien = danhSachSinhVien.find { it.mssv == mssv }

        sinhVien?.run {
            println("Thông tin hiện tại: $this")
            print("Nhập tên mới (bỏ qua nếu không sửa): ")
            val tenMoi = readLine()?.trim()
            if (!tenMoi.isNullOrBlank()) tenSV = tenMoi
            print("Nhập điểm trung bình mới (bỏ qua nếu không sửa): ")
            val diemMoi = readLine()?.toFloatOrNull()
            if (diemMoi != null) diemTB = diemMoi
            println("Thông tin sau khi sửa: $this")
        } ?: println("Không tìm thấy sinh viên với MSSV: $mssv")
    }

    private fun hienThiDanhSach() {
        println("\n=== Danh sách sinh viên ===")
        if (danhSachSinhVien.isEmpty()) {
            println("Danh sách sinh viên trống.")
            return
        }
        with(danhSachSinhVien) {
            println("+----+--------------------+----------+---------+------------+------+")
            println("| STT| Tên SV             | MSSV     | Điểm TB | Đã TN      | Tuổi |")
            println("+----+--------------------+----------+---------+------------+------+")
            forEachIndexed { index, sv ->
                println(
                    "| %2d | %-18s | %-8s | %-7.2f | %-10s | %-4s |".format(
                        index + 1,
                        sv.tenSV,
                        sv.mssv,
                        sv.diemTB,
                        sv.daToNghiep ?: "null",
                        sv.tuoi ?: "null"
                    )
                )
            }
            println("+----+--------------------+----------+---------+------------+------+")
        }
    }

    private fun xoaSinhVien() {
        println("\n=== Xóa sinh viên ===")
        print("Nhập MSSV của sinh viên cần xóa: ")
        val mssv = readLine()?.trim()

        danhSachSinhVien.find { it.mssv == mssv }?.also {
            danhSachSinhVien.remove(it)
            println("Đã xóa sinh viên: $it")
        } ?: println("Không tìm thấy sinh viên với MSSV: $mssv")
    }
}

fun main() {
    val app = ScopeFunctions()
    app.run()
}
