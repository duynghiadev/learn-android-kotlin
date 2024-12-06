package com.tuhoc.bai22_4_crud_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context) :SQLiteOpenHelper(context,"TUHOCDB",null,1) {
    //ctrl + i
    override fun onCreate(db: SQLiteDatabase?) {
        //tạo table , column
        db?.execSQL("CREATE TABLE TUHOC(_id integer primary key autoincrement,user TEXT, email TEXT)")
        //thêm data vào cơ sở dữ liệu
        db?.execSQL("Insert into TUHOC(user,email) values ('mot','mot@gmail.com')")
        db?.execSQL("Insert into TUHOC(user,email) values ('hai','hai@gmail.com')")
        db?.execSQL("Insert into TUHOC(user,email) values ('ba','ba@gmail.com')")
        db?.execSQL("Insert into TUHOC(user,email) values ('tuhoc.cc','tuhoc.cc@gmail.com')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}
