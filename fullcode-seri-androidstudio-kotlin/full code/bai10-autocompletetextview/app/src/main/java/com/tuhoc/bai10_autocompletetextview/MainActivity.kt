package com.tuhoc.bai10_autocompletetextview

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

        //khai báo list danh sách tỉnh thành
        val list = resources.getStringArray(R.array.tinhthanh)

        val adt = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1,
                    list)
        autoTinhThanh.setAdapter(adt)

        //Gợi ý với 0 ký tự nhập vào
        autoTinhThanh.setOnFocusChangeListener({ view, b -> if (b) autoTinhThanh.showDropDown()})
        //kiểm tra xem item nào được chọn
        autoTinhThanh.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,
            "Click item "+autoTinhThanh.text.toString(),
            Toast.LENGTH_SHORT).show()
        })

    }
}