package com.tuhoc.bai16_1_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item.view.*

class RvAdapter (var ds:List<OutData>, val onPhimClick:RvInterface):RecyclerView.Adapter<RvAdapter.PhimViewHolder>(){
    //class viewholder
    inner class PhimViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    //ctrl +i
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhimViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return PhimViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhimViewHolder, position: Int) {
        holder.itemView.apply {
            txtMieuTa.text = ds[position].mieuta
            txtTenPhim.text = ds[position].tenphim
            imgPhim.setImageResource(ds[position].image)

            //lắng nghe item click chọn
            holder.itemView.setOnClickListener {
                onPhimClick.OnClickPhim(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}