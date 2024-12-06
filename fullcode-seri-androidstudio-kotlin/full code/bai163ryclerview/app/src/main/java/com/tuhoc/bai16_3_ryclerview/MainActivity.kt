package com.tuhoc.bai16_3_ryclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Xuly()
    }

    private fun Xuly() {
        var ds= mutableListOf<Int>()
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
        ds.add(R.drawable.tuhoc7)
        ds.add(R.drawable.tuhoc1)
        ds.add(R.drawable.tuhoc2)
        ds.add(R.drawable.tuhoc3)
        ds.add(R.drawable.tuhoc4)
        ds.add(R.drawable.tuhoc5)
        ds.add(R.drawable.tuhoc6)
        ds.add(R.drawable.tuhoc7)

        rvView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val itemAdapter = RvAdapter(ds)
        rvView.adapter = itemAdapter
    }
}