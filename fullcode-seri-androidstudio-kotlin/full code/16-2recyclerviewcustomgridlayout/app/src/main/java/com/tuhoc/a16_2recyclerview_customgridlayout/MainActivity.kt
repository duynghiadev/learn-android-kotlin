package com.tuhoc.a16_2recyclerview_customgridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Ham()
    }

    private fun Ham() {
        var ds = mutableListOf<Int>()
        ds.add(R.drawable.tuhoc1)
        ds.add(R.drawable.tuhoc2)
        ds.add(R.drawable.tuhoc3)
        ds.add(R.drawable.tuhoc4)
        ds.add(R.drawable.tuhoc5)
        ds.add(R.drawable.tuhoc6)
        ds.add(R.drawable.tuhoc7)
        ds.add(R.drawable.tuhoc1)
        ds.add(R.drawable.tuhoc2)
        ds.add(R.drawable.tuhoc3)
        ds.add(R.drawable.tuhoc4)
        ds.add(R.drawable.tuhoc5)
        ds.add(R.drawable.tuhoc6)
        rvView.setHasFixedSize(true)
        rvView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL
        )
        val itemAdapter = ItemAdapter(ds)
        rvView.adapter = itemAdapter

    }
}