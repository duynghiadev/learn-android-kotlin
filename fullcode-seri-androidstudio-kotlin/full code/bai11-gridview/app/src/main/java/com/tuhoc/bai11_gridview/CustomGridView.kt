package com.tuhoc.bai11_gridview

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomGridView(val activity: Activity, val list:List<OutData>): ArrayAdapter<OutData>(activity,R.layout.layout_item) {
    override fun getCount(): Int {
        return list.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater
        val rowView = contexs.inflate(R.layout.layout_item,parent,false)

        val images = rowView.findViewById<ImageView>(R.id.imgPhim)
        val txtPhim = rowView.findViewById<TextView>(R.id.txtTenPhim)

        images.setImageResource(list[position].images)
        txtPhim.text = list[position].tenphim
        return rowView
    }
}