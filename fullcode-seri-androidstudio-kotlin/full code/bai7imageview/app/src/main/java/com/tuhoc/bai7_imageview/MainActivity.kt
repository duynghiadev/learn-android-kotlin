package com.tuhoc.bai7_imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add hàm events
        addEvents()
    }

    private fun addEvents() {
        radPic1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked)
            {
                imgHinhAnh.setImageResource(R.drawable.pic1)
            }
        }
        radPic2.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked)
            {
                imgHinhAnh.setImageResource(R.drawable.pic2)
            }
        }

        //code nút thoát
        btnThoat.setOnClickListener {
            finish()

        }
    }
}