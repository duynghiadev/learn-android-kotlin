package com.example.lab1_md18306

data class SinhVien(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daToNghiep: Boolean?,
    var tuoi: Int?
)

class Lab2 {
    private val danhSachSinhVien = mutableListOf<SinhVien>()

    fun run() {
        while (true) {
            println("\n=== Quản lý sinh viên ===")
            println("1. Thêm sinh viên")
            println("2. Sửa thông tin sinh viên")
            println("3. Xóa sinh viên")
            println("4. Xem danh sách sinh viên")
            println("5. Thoát")
            print("Nhập lựa chọn của bạn: ")

            when (readLine()?.toIntOrNull()) {
                1 -> themSinhVien()
                2 -> suaSinhVien()
                3 -> xoaSinhVien()
                4 -> xemDanhSachSinhVien()
                5 -> {
                    println("Cảm ơn bạn đã sử dụng chương trình!")
                    return
                }

                else -> println("Lựa chọn không hợp lệ. Vui lòng thử lại.")
            }
        }
    }

    private fun themSinhVien() {
        println("\n=== Thêm sinh viên ===")

        // Nhập tên sinh viên
        var tenSV: String?
        do {
            print("Nhập tên sinh viên: ")
            tenSV = readLine()?.trim()
            if (tenSV.isNullOrBlank()) {
                println("Tên sinh viên không được để trống. Vui lòng nhập lại.")
            }
        } while (tenSV.isNullOrBlank())

        // Nhập MSSV
        var mssv: String?
        do {
            print("Nhập MSSV: ")
            mssv = readLine()?.trim()
            if (mssv.isNullOrBlank()) {
                println("MSSV không được để trống. Vui lòng nhập lại.")
            }
        } while (mssv.isNullOrBlank())

        // Nhập điểm trung bình
        var diemTB: Float?
        do {
            print("Nhập điểm trung bình: ")
            diemTB = readLine()?.toFloatOrNull()
            if (diemTB == null || diemTB !in 0f..10f) {
                println("Điểm trung bình phải là số từ 0 đến 10. Vui lòng nhập lại.")
            }
        } while (diemTB == null || diemTB !in 0f..10f)

        // Nhập trạng thái tốt nghiệp
        var daToNghiep: Boolean? = null
        do {
            print("Sinh viên đã tốt nghiệp chưa? (true/false): ")
            val input = readLine()?.trim()
            if (input.equals("true", true) || input.equals("false", true)) {
                daToNghiep = input?.toBooleanStrict()
            } else if (input.isNullOrBlank()) {
                daToNghiep = null // Cho phép bỏ trống
                break
            } else {
                println("Vui lòng nhập 'true', 'false' hoặc để trống.")
            }
        } while (daToNghiep == null && input != null)

        // Nhập tuổi
        var tuoi: Int?
        do {
            print("Nhập tuổi: ")
            tuoi = readLine()?.toIntOrNull()
            if (tuoi != null && tuoi <= 0) {
                println("Tuổi phải là số nguyên dương. Vui lòng nhập lại.")
            }
        } while (tuoi != null && tuoi <= 0)

        // Tạo đối tượng sinh viên và thêm vào danh sách
        val sinhVien = SinhVien(tenSV, mssv, diemTB, daToNghiep, tuoi)
        danhSachSinhVien.add(sinhVien)
        println("Thêm sinh viên thành công!")
    }


    private fun suaSinhVien() {
        println("\n=== Sửa thông tin sinh viên ===")
        print("Nhập MSSV của sinh viên cần sửa: ")
        val mssv = readLine()?.trim()
        val sinhVien = danhSachSinhVien.find { it.mssv == mssv }

        if (sinhVien == null) {
            println("Không tìm thấy sinh viên với MSSV: $mssv")
            return
        }

        println("Thông tin hiện tại: $sinhVien")
        print("Nhập tên mới (bỏ qua nếu không muốn thay đổi): ")
        val tenMoi = readLine()?.trim()
        print("Nhập điểm trung bình mới (bỏ qua nếu không muốn thay đổi): ")
        val diemMoi = readLine()?.toFloatOrNull()
        print("Sinh viên đã tốt nghiệp chưa? (true/false, bỏ qua nếu không muốn thay đổi): ")
        val totNghiepMoi = readLine()?.toBooleanStrictOrNull()
        print("Nhập tuổi mới (bỏ qua nếu không muốn thay đổi): ")
        val tuoiMoi = readLine()?.toIntOrNull()

        if (!tenMoi.isNullOrBlank()) sinhVien.tenSV = tenMoi
        if (diemMoi != null) sinhVien.diemTB = diemMoi
        if (totNghiepMoi != null) sinhVien.daToNghiep = totNghiepMoi
        if (tuoiMoi != null) sinhVien.tuoi = tuoiMoi

        println("Cập nhật thông tin sinh viên thành công!")
    }

    private fun xoaSinhVien() {
        println("\n=== Xóa sinh viên ===")
        print("Nhập MSSV của sinh viên cần xóa: ")
        val mssv = readLine()?.trim()
        val sinhVien = danhSachSinhVien.find { it.mssv == mssv }

        if (sinhVien == null) {
            println("Không tìm thấy sinh viên với MSSV: $mssv")
            return
        }

        danhSachSinhVien.remove(sinhVien)
        println("Xóa sinh viên thành công!")
    }

    private fun xemDanhSachSinhVien() {
        println("\n=== Danh sách sinh viên ===")
        if (danhSachSinhVien.isEmpty()) {
            println("Danh sách sinh viên trống.")
            return
        }

        println("+----+--------------------+----------+---------+------------+------+")
        println("| STT| Tên SV             | MSSV     | Điểm TB | Đã TN      | Tuổi |")
        println("+----+--------------------+----------+---------+------------+------+")
        danhSachSinhVien.forEachIndexed { index, sv ->
            println(
                "| %2d | %-18s | %-8s | %-7.2f | %-10s | %-4s |".format(
                    index + 1,
                    sv.tenSV,
                    sv.mssv,
                    sv.diemTB,
                    sv.daToNghiep?.toString() ?: "null",
                    sv.tuoi?.toString() ?: "null"
                )
            )
        }
        println("+----+--------------------+----------+---------+------------+------+")
    }
}

fun main() {
    val lab2 = Lab2()
    lab2.run()
}
