package com.tuhoc.bai5_1xulysukientrenview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNhapA = findViewById<EditText>(R.id.edtNhapA)
        val edtNhapB = findViewById<EditText>(R.id.edtNhapB)
        val edtKQ = findViewById<EditText>(R.id.edtKQ)
        val btnCong = findViewById<Button>(R.id.btnCong)
        val btnReset = findViewById<Button>(R.id.btnReSet)
        val btnNhan = findViewById<Button>(R.id.btnNhan)
        val btnChia = findViewById<Button>(R.id.btnChia)
        val btnNhanLau = findViewById<Button>(R.id.btnNhanLau)
        val btnThoat = findViewById<Button>(R.id.btnThoat)

        //set text cho edtNhapA
        //edtNhapA.setText("ố là la")

        btnCong.setOnClickListener {
            val A = edtNhapA.text.toString().toInt()
            val B = edtNhapB.text.toString().toInt()
            val kq = A+B
            edtKQ.setText(kq.toString())
        }

        btnReset.setOnClickListener {
            edtNhapA.setText("")
            edtNhapB.setText("")
            edtKQ.setText("")
            //Thông báo nhanh trên màn hình
            Toast.makeText(this, "Em đã xoá hết rồi nhé",Toast.LENGTH_LONG).show()
        }

        //4. Tạo sự kiện chia sẻ: 1 biến có thể chia sẻ sự kiện cho >= 2 view
        var suKienChiaSe: View.OnClickListener? = null
        suKienChiaSe = View.OnClickListener {
            if (it==btnNhan)
            {
                val A = edtNhapA.text.toString().toInt()
                val B = edtNhapB.text.toString().toInt()
                val kq = A*B
                edtKQ.setText(kq.toString())
            }
            else if (it==btnChia)
            {
                val A = edtNhapA.text.toString().toDouble()
                val B = edtNhapB.text.toString().toDouble()
                val kq = A/B
                edtKQ.setText(kq.toString())
            }
        }
        btnNhan.setOnClickListener(suKienChiaSe)
        btnChia.setOnClickListener(suKienChiaSe)

        //5.Nhấn lâu
        var suKienNhanLau: View.OnLongClickListener? = null
        suKienNhanLau =View.OnLongClickListener {
            if (it==btnNhanLau)
            {
                Toast.makeText(this,"Long click detected",Toast.LENGTH_SHORT).show()
                btnNhanLau.visibility =View.GONE // ẩn btn
            }
            else if (it==btnNhan)
            {
                Toast.makeText(this,"Long click detected",Toast.LENGTH_SHORT).show()
                btnNhan.visibility =View.GONE // ẩn btn
            }
            true

        }
        btnNhanLau.setOnLongClickListener(suKienNhanLau)
        btnNhan.setOnLongClickListener(suKienNhanLau)

        //thoát
        btnThoat.setOnClickListener{
            Toast.makeText(this, "Gà lại lập trình"+"\n Cảm ơn bạn đã sử dụng phần mềm",Toast.LENGTH_LONG).show()
            finish()
        }


    }
}