package com.tuhoc.bai8_1_lvnguondulieuthaydoi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //khai báo list rỗng
    var ds:MutableList<String> = mutableListOf("0901520111","0901222444")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //hiển thị danh sách ban đầu
        lvTen.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            ds
        )
        addEvents()

    }

    private fun addEvents() {
        //code cho button lưu
         btnLuu.setOnClickListener {
             hamXuLyNutLuu()
         }
    }
    private fun hamXuLyNutLuu() {
        var s:String = edtTen.text.toString()
        ds.add(s) // thêm sdt vào list ds
        edtTen.setText("")
        edtTen.requestFocus()// đẩy con trỏ văn bản vào ô nhập liệu

        lvTen.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            ds
        )
    }
}
