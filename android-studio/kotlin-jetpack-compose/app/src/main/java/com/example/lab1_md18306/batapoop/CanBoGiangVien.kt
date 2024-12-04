package com.example.lab1_md18306.batapoop

class CBGV(
    hoten: String,
    tuoi: Int?,
    quequan: String?,
    var msgv: String,
    var luongcung: Float,
    var lThuong: Float?,
    var lPhat: Float?
) : NguoiModel(hoten, tuoi, quequan) {
    var lThucLinh: Float = 0f
        get() = luongcung + (lThuong ?: 0f) - (lPhat ?: 0f)

    override fun getThongTin(): String {
        return "Cán Bộ Giảng Viên: ${super.getThongTin()} - Mã Số Giảng Viên: $msgv - Lương thực lĩnh: " +
                "$lThucLinh"
    }
}