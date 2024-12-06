package com.tuhoc.bai14_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_manhinh2.*

class manhinh2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manhinh2)

        //get dữ liệu bằng bundle
        val i = intent
        //lấy bundle ra khỏi intent
        val bundle = i.extras
        if (bundle != null)
        {
            val bienStringsss = bundle.getString("bienString")
            val bienDouble = bundle.getDouble("bienDouble")
            val bienBool = bundle.getBoolean("bienBool")
            val bienInt = bundle.getInt("bienInt")

            edtGetIntent.setText(bienStringsss+"\n" +bienDouble +"\n" +bienInt +"\n" +bienBool)

        }

        //get dữ liệu từ intent main
        /*val i = intent
        val bienStringsss = i.getStringExtra("bienString")
        val bienDouble = i.getDoubleExtra("bienDoublerrrr",0.0)
        val bienBool = i.getBooleanExtra("bienBoolrrrr",false)
        edtGetIntent.setText(bienStringsss+"\n" +bienDouble+"\n" +bienBool )*/


        //gọi lệnh quay trở lại màn hình main
        btnQuayLai.setOnClickListener {
            val i3 = Intent(this,MainActivity::class.java)
            startActivity(i3)
        }
        }
    }
