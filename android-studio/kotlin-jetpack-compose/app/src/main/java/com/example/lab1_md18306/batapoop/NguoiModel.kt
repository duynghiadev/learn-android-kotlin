package com.example.lab1_md18306.batapoop

open class NguoiModel(var hoten: String, var tuoi: Int?, var quequan: String?) {
    open fun getThongTin(): String {
        return "$hoten - Tuổi: $tuoi - Quê Quán: $quequan"
    }
}