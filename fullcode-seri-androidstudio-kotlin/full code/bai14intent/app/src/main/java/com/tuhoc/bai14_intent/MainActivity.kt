package com.tuhoc.bai14_intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_manhinh2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //gọi màn hình 2 từ màn hình main
        btnGo.setOnClickListener {
            val i = Intent(this,manhinh2::class.java)

            //truyền dữ liệu bằng bundle
            //1. nạp dữ liệu
            val bundle = Bundle()
            bundle.putString("bienString","chào mừng đến với tuhoc.cc")
            bundle.putDouble("bienDouble",123456.789)
            bundle.putBoolean("bienBool",true)
            bundle.putInt("bienInt",78)

            //đặt bundle vào trong intent
            i.putExtras(bundle)

            //truyền dữ liệu trực tiếp bằng intent ctrl + shift  + /
            /*i.putExtra("bienString","chào mừng đến với tuhoc.cc")
            i.putExtra("bienDouble",123456.789)
            i.putExtra("bienBool",true)*/

            startActivity(i)
        }

        //gọi url từ màn hình main
        btnGo2.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW,
                Uri.parse("http://tuhoc.cc"))
            startActivity(i2)
        }
    }
}