package com.tuhoc.bai92customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //tạo hàm custom spinner
        setupCustomSpinner()
    }

    private fun setupCustomSpinner() {
        //khai báo list món ăn cho vào list2
        var list2 = mutableListOf<OutData>()
        list2.add(OutData(R.drawable.cam,"Cam tươi"))
        list2.add(OutData(R.drawable.duahau,"Dưa hấu Sài Gòn"))
        list2.add(OutData(R.drawable.tao,"Táo Trung Quổ"))
        list2.add(OutData(R.drawable.sauchung,"Sầu Riêng không mùi"))
        list2.add(OutData(R.drawable.xoai,"Xoài lắc nam bộ"))

        val customSpinner = CustomSpinner(this, list2)
        spCustom.adapter = customSpinner

        //lắng nghe thấu hiểu
        spCustom.onItemSelectedListener = object  :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity, "Bạn chọn "+list2[p2].mieuta,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
}