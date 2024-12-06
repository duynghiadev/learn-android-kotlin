package com.tuhoc.bai21_navigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sử dụng màu cho icon menu
        nav_leftmenu.itemIconTintList = null

        //lắng nghe sự kiện click lên các item menu
        nav_leftmenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_Home->Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
                R.id.nav_message->Toast.makeText(this,"Message",Toast.LENGTH_SHORT).show()
                R.id.nav_exit->finish()
            }
            true
        }
    }
}