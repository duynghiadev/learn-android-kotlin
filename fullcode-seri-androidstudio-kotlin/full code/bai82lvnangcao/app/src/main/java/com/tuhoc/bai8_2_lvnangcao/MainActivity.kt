package com.tuhoc.bai8_2_lvnangcao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khai báo danh sách các item list
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.giatocrong,"Gia Tộc Rồng 2022","Đây là miêu tả của gia tộc rồng"))
        list.add(OutData(R.drawable.hoanhon,"Hoàn Hồn 2022","phim giả tưởng"))
        list.add(OutData(R.drawable.thanlan,"Thần Lan Vô Song","phim kiếm hiệp"))
        list.add(OutData(R.drawable.banghoa,"Băng Hỏa Ma Trù 2021","Băng Hỏa Ma Trù"))
        list.add(OutData(R.drawable.giatocrong,"Gia Tộc Rồng 2022","Đây là miêu tả của gia tộc rồng"))
        list.add(OutData(R.drawable.hoanhon,"Hoàn Hồn 2022","phim giả tưởng"))
        list.add(OutData(R.drawable.thanlan,"Thần Lan Vô Song","phim kiếm hiệp"))
        list.add(OutData(R.drawable.banghoa,"Băng Hỏa Ma Trù 2021","Băng Hỏa Ma Trù"))
        list.add(OutData(R.drawable.giatocrong,"Gia Tộc Rồng 2022","Đây là miêu tả của gia tộc rồng"))
        list.add(OutData(R.drawable.hoanhon,"Hoàn Hồn 2022","phim giả tưởng"))
        list.add(OutData(R.drawable.thanlan,"Thần Lan Vô Song","phim kiếm hiệp"))
        list.add(OutData(R.drawable.banghoa,"Băng Hỏa Ma Trù 2021","Băng Hỏa Ma Trù"))

        customAdapter= CustomAdapter(this, list)
        //khai báo biến để link đến lvPhim
        val lvPhim = findViewById<ListView>(R.id.lvPhim)
        lvPhim.adapter = customAdapter
        //listview item click listener
        lvPhim.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,"Bạn chọn "+list[i].title,Toast.LENGTH_LONG).show()
        }

        }
}