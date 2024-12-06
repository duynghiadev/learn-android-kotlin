package com.tuhoc.bai8_listviewcoban

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //test thử chuyển màu cho list view
        val mauxanh = Color.parseColor("#99FFFF")
        lvQuocGia.setBackgroundColor(mauxanh)

        //addevents()
        addEvents()

    }

    private fun addEvents() {
        hienthilvQuocGia()
    }

    private fun hienthilvQuocGia() {
        //khai báo arrQuocGia sử dụng resources để lấy thông tin từ string.xml
        var arrQuocGia = resources.getStringArray(R.array.arrQuocGia)
        // gán nguồn cho adapter để hiển thị lên lv
        lvQuocGia.adapter =ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            arrQuocGia)

        lvQuocGia.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(
                this,
                "Bạn chọn" + arrQuocGia[i],
                Toast.LENGTH_LONG
            ).show()
        }
    }
}