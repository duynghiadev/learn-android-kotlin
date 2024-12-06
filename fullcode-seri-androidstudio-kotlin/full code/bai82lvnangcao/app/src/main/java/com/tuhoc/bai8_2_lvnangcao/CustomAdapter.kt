package com.tuhoc.bai8_2_lvnangcao

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter (val activity: Activity, val list: List<OutData>) : ArrayAdapter<OutData>(activity,R.layout.list_item) {
    override fun getCount(): Int {
        return list.size // vẽ lên view hết tất cả các dòng của list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val contexs = activity.layoutInflater
        // layoutInflater là 1 component
        //giúp chuyển đổi layout xml thành View trong android
        val rowView = contexs.inflate(R.layout.list_item, parent,false )

        val images = rowView.findViewById<ImageView>(R.id.images)
        val title = rowView.findViewById<TextView>(R.id.title)
        val desc = rowView.findViewById<TextView>(R.id.desc)

        title.text = list[position].title
        desc.text = list[position].desc
        images.setImageResource(list[position].image)

        return rowView
    }
}