package com.tuhoc.bai19_1_alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnExit.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.apply {
                //tiêu đề của thông báo
                setTitle("Confirm Window")
                //nội dung thông báo
                setMessage("Do you want to close this app?")
                //nút phủ định
                setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                //nút khẳng định
                setPositiveButton("Yes"){ dialogInterface: DialogInterface, i: Int ->
                    finish()
                }
                //ngăn không cho đóng dialog khi click ra ngoài
                setCancelable(false)
            }
            dialog.show()
        }
    }
}