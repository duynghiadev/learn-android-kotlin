package com.tuhoc.bai11_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khai báo list danh sách các bộ phim
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.banghoa,"Băng Hoả Ma Trù"))
        list.add(OutData(R.drawable.hoanhon,"Hoàn Hồn 2022"))
        list.add(OutData(R.drawable.rong,"Gia Tộc Rồng"))
        list.add(OutData(R.drawable.thanlan,"Thần Lan Chi Mộng"))
        list.add(OutData(R.drawable.banghoa,"Băng Hoả Ma Trù"))
        list.add(OutData(R.drawable.hoanhon,"Hoàn Hồn 2022"))
        list.add(OutData(R.drawable.rong,"Gia Tộc Rồng"))
        list.add(OutData(R.drawable.thanlan,"Thần Lan Chi Mộng"))
        list.add(OutData(R.drawable.banghoa,"Băng Hoả Ma Trù"))
        list.add(OutData(R.drawable.hoanhon,"Hoàn Hồn 2022"))
        list.add(OutData(R.drawable.rong,"Gia Tộc Rồng"))
        list.add(OutData(R.drawable.thanlan,"Thần Lan Chi Mộng"))
        list.add(OutData(R.drawable.banghoa,"Băng Hoả Ma Trù"))
        list.add(OutData(R.drawable.hoanhon,"Hoàn Hồn 2022"))
        list.add(OutData(R.drawable.rong,"Gia Tộc Rồng"))
        list.add(OutData(R.drawable.thanlan,"Thần Lan Chi Mộng"))
        list.add(OutData(R.drawable.banghoa,"Băng Hoả Ma Trù"))
        list.add(OutData(R.drawable.hoanhon,"Hoàn Hồn 2022"))
        list.add(OutData(R.drawable.rong,"Gia Tộc Rồng"))
        list.add(OutData(R.drawable.thanlan,"Thần Lan Chi Mộng"))

        val customGV = CustomGridView(this, list)
        gvPhim.adapter = customGV
        //lắng nghe xem có item  nào được chọn trên gridview không ?
        gvPhim.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,
            "Bạn chọn "+list[i].tenphim,
            Toast.LENGTH_SHORT).show()
        }
    }
}