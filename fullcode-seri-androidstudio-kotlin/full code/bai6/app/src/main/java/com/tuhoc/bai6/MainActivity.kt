package com.tuhoc.bai6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val btnTest = findViewById<Button>(R.id.btnTest)
        addEvents()
    }

    private fun addEvents() {
        //xử lý sự kiện khi click vào nút chọn sở thích
        btnChonSoThich.setOnClickListener {
            xuLyChonSoThich()
        }

        //xử lý xác nhận giới tính
        btnXacNhan.setOnClickListener {
            xuLyXacNhan()
        }

    }

    private fun xuLyXacNhan() {
        var s:String=""
        if (radNam.isChecked)
            s=radNam.text.toString()
        else if (radNu.isChecked)
            s=radNu.text.toString()
        //xử lý chuỗi s
        if (s=="")
            Toast.makeText(this, "Bạn chưa chọn giới tính",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Bạn chọn giới tính"+s,Toast.LENGTH_SHORT).show()
    }

    private fun xuLyChonSoThich() {
        var s:String=""
        if (chkNgheNhac.isChecked)
            s+=chkNgheNhac.text.toString()+"\n"
        if (chkXemPhim.isChecked)
            s+=chkXemPhim.text.toString()+"\n"
        if (chkChoiTheThao.isChecked)
            s+=chkChoiTheThao.text.toString()+"\n"
        if (chkShopping.isChecked)
            s+=chkShopping.text.toString()+"\n"
        if (chkDuLich.isChecked)
            s+=chkDuLich.text.toString()+"\n"

        //gán vào ô edtSoThich
        edtSoThich.setText(s)
    }

}