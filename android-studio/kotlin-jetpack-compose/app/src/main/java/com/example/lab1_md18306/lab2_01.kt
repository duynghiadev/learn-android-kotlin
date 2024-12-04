package com.example.lab1_md18306

data class SinhVien1(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daToNghiep: Boolean?,
    var tuoi: Int?
) {
    // Hàm khởi tạo (constructor) tùy chỉnh cho SinhVien1
    constructor(tenSV: String, mssv: String, diemTB: Float) : this(tenSV, mssv, diemTB, null, null)
}

class Lab2_01 {
    // Mutable List, Set và Map cho các thông tin sinh viên
    private val danhSachSinhVien = mutableListOf<SinhVien1>()
    private val mssvSet = mutableSetOf("12345", "67890", "11223")
    private val diemMap = mutableMapOf<String, Float>("12345" to 8.5f, "67890" to 7.0f)

    // Hàm chính chạy chương trình
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

    // Hàm thêm sinh viên
    private fun themSinhVien() {
        println("\n=== Thêm sinh viên ===")

        var tenSV: String?
        do {
            print("Nhập tên sinh viên: ")
            tenSV = readLine()?.trim()
            if (tenSV.isNullOrBlank()) {
                println("Tên sinh viên không được để trống. Vui lòng nhập lại.")
            }
        } while (tenSV.isNullOrBlank())

        var mssv: String?
        do {
            print("Nhập MSSV: ")
            mssv = readLine()?.trim()
            if (mssv.isNullOrBlank()) {
                println("MSSV không được để trống. Vui lòng nhập lại.")
            }
        } while (mssv.isNullOrBlank())

        // Kiểm tra MSSV có trùng trong Set không
        if (mssvSet.contains(mssv)) {
            println("MSSV này đã tồn tại.")
            return
        }

        var diemTB: Float?
        do {
            print("Nhập điểm trung bình: ")
            diemTB = readLine()?.toFloatOrNull()
            if (diemTB == null || diemTB !in 0f..10f) {
                println("Điểm trung bình phải là số từ 0 đến 10. Vui lòng nhập lại.")
            }
        } while (diemTB == null || diemTB !in 0f..10f)

        var daToNghiep: Boolean? = null
        do {
            print("Sinh viên đã tốt nghiệp chưa? (true/false): ")
            val input = readLine()?.trim()
            if (input.equals("true", true) || input.equals("false", true)) {
                daToNghiep = input?.toBooleanStrict()
            } else if (input.isNullOrBlank()) {
                daToNghiep = null
                break
            } else {
                println("Vui lòng nhập 'true', 'false' hoặc để trống.")
            }
        } while (daToNghiep == null && input != null)

        var tuoi: Int?
        do {
            print("Nhập tuổi: ")
            tuoi = readLine()?.toIntOrNull()
            if (tuoi != null && tuoi <= 0) {
                println("Tuổi phải là số nguyên dương. Vui lòng nhập lại.")
            }
        } while (tuoi != null && tuoi <= 0)

        val sinhVien = SinhVien1(tenSV, mssv, diemTB, daToNghiep, tuoi)
        danhSachSinhVien.add(sinhVien)
        mssvSet.add(mssv!!)  // Thêm MSSV vào Set
        diemMap[mssv!!] = diemTB!!  // Thêm điểm vào Map
        println("Thêm sinh viên thành công!")
    }

    // Hàm sửa sinh viên
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

        diemMap[sinhVien.mssv] = sinhVien.diemTB // Cập nhật lại điểm trong Map

        println("Cập nhật thông tin sinh viên thành công!")
    }

    // Hàm xóa sinh viên
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
        mssvSet.remove(mssv)  // Xóa MSSV khỏi Set
        diemMap.remove(mssv)  // Xóa điểm khỏi Map
        println("Xóa sinh viên thành công!")
    }

    // Hàm xem danh sách sinh viên
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
    val lab2_01 = Lab2_01()
    lab2_01.run()
}
