package com.tuhoc.bai9_spinnercoban

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //hàm test spinner cơ bản
        setupSpinnerCoBan()
    }

    private fun setupSpinnerCoBan() {
        //tạo 1 list ngôn ngữ
        //val list = resources.getStringArray(R.array.ngonngu)
        val list= mutableListOf<String>()
        list.add("English")
        list.add("Việt Nam")
        list.add("Tây Ban Nha")
        list.add("English")
        list.add("Việt Nam")
        list.add("Tây Ban Nha")
        //khai báo bộ điều hướng
        val adt = ArrayAdapter(this,
        android.R.layout.simple_spinner_item,// cách hiển thị 1 dòng
        list)
        //gọi spinner
        spNgonNgu.adapter = adt
        //onItemSelectedListener
        spNgonNgu.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity,"Bạn chọn "+list[p2], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}