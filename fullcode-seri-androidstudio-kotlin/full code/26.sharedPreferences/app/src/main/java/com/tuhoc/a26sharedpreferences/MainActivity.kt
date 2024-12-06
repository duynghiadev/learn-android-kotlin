package com.tuhoc.a26sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //khai báo các biến
    var dem=0
    var send:String? = null
    var message:String? = null
    var isChecked:Boolean?= null
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDem.setOnClickListener {
            dem++
            btnDem.text= dem.toString()
        }
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        trieuHoiData()
    }

    private fun trieuHoiData() {
        sharedPreferences= this.getSharedPreferences("saveData",Context.MODE_PRIVATE)
        send = sharedPreferences.getString("key_send",null)
        message= sharedPreferences.getString("key_mes",null)
        dem= sharedPreferences.getInt("key_dem",0)
        isChecked = sharedPreferences.getBoolean("key_remember",false)

        edtSend.setText(send)
        edtMessage.setText(message)
        btnDem.text=dem.toString()
        chkRemember.isChecked =isChecked!!


    }

    private fun saveData() {
        sharedPreferences= this.getSharedPreferences("saveData",Context.MODE_PRIVATE)
        send = edtSend.text.toString()
        message = edtMessage.text.toString()
        isChecked = chkRemember.isChecked

        //lưu thông tin , key phải là duy nhất
        val editor = sharedPreferences.edit()
        editor.putString("key_send",send)
        editor.putString("key_mes",message)
        editor.putInt("key_dem",dem)
        editor.putBoolean("key_remember",isChecked!!)
        editor.apply()
        Toast.makeText(applicationContext,"Data đã được lưu",Toast.LENGTH_SHORT).show()
    }
}