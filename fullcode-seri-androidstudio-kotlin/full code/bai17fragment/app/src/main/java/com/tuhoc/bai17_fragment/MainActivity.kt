package com.tuhoc.bai17_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sub1 = Fragment1()
        val sub2 = Fragment2()


        btnf1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1,sub1)
                commit()
            }
        }

        btnf2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1,sub2)
                commit()
            }
        }
    }
}