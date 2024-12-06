package com.tuhoc.bai19_2_customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.tuhoc.bai19_2_customdialog.databinding.CustomDialogBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.setOnClickListener {
            showDialogBinding() //alt + enter
        }

    }

    private fun showDialogBinding() {
        val build = AlertDialog.Builder(this,R.style.Themecustom)
        val dialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(this))
        build.setView(dialogBinding.root)
        //close
        dialogBinding.btnClose.setOnClickListener { dialog.dismiss() }
        //tham gia
        dialogBinding.btnThamGia.setOnClickListener {
            Toast.makeText(this,
                "Bạn đã tham gia thành công",
                Toast.LENGTH_SHORT).show()
        }
        dialog = build.create()
        dialog.show()
    }

    private fun showDialogNormal() {
        val build = AlertDialog.Builder(this,R.style.Themecustom)
        val view = layoutInflater.inflate(R.layout.custom_dialog,null)
        build.setView(view)
        //code close
        val btnClose = view.findViewById<ImageButton>(R.id.btnClose)
        btnClose.setOnClickListener { dialog.dismiss() }
        //code cho nút tham gia
        val btnThamGia = view.findViewById<Button>(R.id.btnThamGia)
        btnThamGia.setOnClickListener {
            Toast.makeText(this,
            "Bạn đã tham gia thành công",
            Toast.LENGTH_SHORT).show()
        }

        dialog = build.create()
        dialog.show()
    }
}