package com.tuhoc.bai15_vongdoiactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show()

        //gọi manhinh2 từ màn hình main
        btnGo.setOnClickListener {
            val intent1 = Intent(this,manhinh2::class.java)
            startActivity(intent1)
        }

        //gọi manhinh3 từ màn hình main
        btnGo3.setOnClickListener {
            val intent3 = Intent(this,manhinh3::class.java)
            startActivity(intent3)
        }
    }

    //ctrl + o
    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show()
    }
}


