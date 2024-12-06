package com.tuhoc.bai16_1_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tạo ds
        val ds = mutableListOf<OutData>()
        ds.add(OutData(R.drawable.banghoa,"Băng Hoả Ma Trù","Phim Trung Quốc"))
        ds.add(OutData(R.drawable.hoanhon,"Hoàn Hồn","Phim Trung Quốc"))
        ds.add(OutData(R.drawable.rong,"Gia Tộc Rồng","Phim Trung Quốc"))
        ds.add(OutData(R.drawable.thanlan,"Thần Lan Chi Mộng","Phim Trung Quốc"))
        ds.add(OutData(R.drawable.banghoa,"Băng Hoả Ma Trù","Phim Trung Quốc"))
        ds.add(OutData(R.drawable.hoanhon,"Hoàn Hồn","Phim Trung Quốc"))
        ds.add(OutData(R.drawable.rong,"Gia Tộc Rồng","Phim Trung Quốc"))
        ds.add(OutData(R.drawable.thanlan,"Thần Lan Chi Mộng","Phim Trung Quốc"))

        val adaptervv = RvAdapter(ds,object :RvInterface{
            override fun OnClickPhim(pos: Int) {
                Toast.makeText(this@MainActivity,
                "Bạn đã click vào ${ds[pos].tenphim} ",
                Toast.LENGTH_SHORT).show()
            }

        })
        rvDemo.adapter= adaptervv
        rvDemo.layoutManager = GridLayoutManager(
            this,
            2,
            GridLayoutManager.HORIZONTAL,
            false
        )
    }
}
