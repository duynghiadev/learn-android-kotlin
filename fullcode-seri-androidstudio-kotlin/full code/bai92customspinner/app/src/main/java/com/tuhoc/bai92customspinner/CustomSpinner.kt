package com.tuhoc.bai92customspinner

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomSpinner (val activity: Activity, val list2:List<OutData>): ArrayAdapter<OutData>(activity,R.layout.list_monan){
    override fun getCount(): Int {
        return list2.size // vẽ bao nhiêu dòng lên spinner
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //position: Int Vị trí của món ăn trong danh sách list
        //convertView: View? chế độ xem cho từng mục trong spinner
        // parent: ViewGroup : Viewgroup cha đang chứa spinner
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    //hàm xử lý view
    private fun initView(position: Int, convertView: View?, parent: ViewGroup) :View {
        val contexs = activity.layoutInflater
        // layoutInflater là 1 component
        //giúp chuyển đổi layout xml thành View trong android
        val rowView = contexs.inflate(R.layout.list_monan,parent,false)
        //cơ bản là dòng lệnh này sẽ biến xml layout thành view

        val images = rowView.findViewById<ImageView>(R.id.images)
        val txtMonAn = rowView.findViewById<TextView>(R.id.txtMonAn)

        images.setImageResource(list2[position].image)
        txtMonAn.text = list2[position].mieuta
        return rowView
    }
}
