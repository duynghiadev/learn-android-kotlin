package com.tuhoc.bai12_datetimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    //khai báo biến today get ngày tháng hiện tại
    val today = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startHour = today.get(Calendar.HOUR_OF_DAY)
        val startMinute = today.get(Calendar.MINUTE)
        //1. set thời gian khi click vào button time
        //lắng nghe click lên button time
        btnTime.setOnClickListener {
            //Timepicker
            TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                //i: Giờ khi người dùng chọn
                //i2: Phút
                txtTime.setText("$i:$i2")
            },startHour,startMinute,false).show()
        }

        //datepicker
        //lắng nghe click lên button btndate
        btnDate.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                //i: năm
                //i2: tháng
                //i3: ngày
                txtDate.setText("$i3/${i2+1}/$i")
            },2007,7,7).show()
        }

    }
}