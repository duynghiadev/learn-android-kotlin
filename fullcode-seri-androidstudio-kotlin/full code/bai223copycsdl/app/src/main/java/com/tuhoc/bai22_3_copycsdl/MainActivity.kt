package com.tuhoc.bai22_3_copycsdl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var db:CopyDbHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sao chép db
        db= CopyDbHelper(this)
        db?.openDatabase()
    }
}