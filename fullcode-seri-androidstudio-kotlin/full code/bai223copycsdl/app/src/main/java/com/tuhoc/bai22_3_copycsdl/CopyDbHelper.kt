package com.tuhoc.bai22_3_copycsdl

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class CopyDbHelper (private val context: Context) {
    companion object{
        private val DB_NAME = "TUHOCDB.db"
    }

    fun openDatabase(): SQLiteDatabase{
        val dbFile = context.getDatabasePath(DB_NAME)
        val file = File(dbFile.toString())
        Log.wtf("DB",dbFile.toString())
        if (file.exists()){
            //không làm gì cả
            Log.e("tuhoc","file đã tồn tại")
        }
        else{
            copyDatabase(dbFile)
        }
        return SQLiteDatabase.openDatabase(dbFile.path,null,SQLiteDatabase.OPEN_READWRITE)
    }

    private fun copyDatabase(dbFile: File?) {
        val openDB = context.assets.open(DB_NAME)
        val outputStream = FileOutputStream(dbFile)
        val buffer = ByteArray(1024)
        while (openDB.read(buffer)>0){
            outputStream.write((buffer))
            Log.wtf("DB","Writing")
        }
        outputStream.flush()
        outputStream.close()
        openDB.close()
        Log.wtf("DB","copy DB complete")
    }
}