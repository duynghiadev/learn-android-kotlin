package com.tuhoc.bai22_2_sqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = MyDbHelper(applicationContext)
        val db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS",null)

        if (rs.moveToLast())
            Toast.makeText(applicationContext,rs.getString(2),Toast.LENGTH_SHORT).show()

        //lắng nghe sự kiện click lên btnAdd
        btnAdd.setOnClickListener {
            var cv = ContentValues()
            cv.put("UNAME",edtUser.text.toString())
            cv.put("PWD",edtPWD.text.toString())
            db.insert("USERS",null,cv)
            Toast.makeText(applicationContext,"Add thành công",Toast.LENGTH_SHORT).show()
            //rs 2 ô nhập liệu
            edtUser.setText("")
            edtPWD.setText("")
            edtUser.requestFocus()

        }
    }
}