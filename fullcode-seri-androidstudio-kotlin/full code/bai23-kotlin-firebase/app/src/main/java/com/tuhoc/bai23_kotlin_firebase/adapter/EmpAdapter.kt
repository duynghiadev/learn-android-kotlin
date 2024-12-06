package com.tuhoc.bai23_kotlin_firebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.tuhoc.bai23_kotlin_firebase.EmployeeModel
import com.tuhoc.bai23_kotlin_firebase.R
import kotlinx.android.synthetic.main.emp_list_item.view.*

//bài 16
class EmpAdapter(private val ds:ArrayList<EmployeeModel>) :RecyclerView.Adapter<EmpAdapter.ViewHolder>() {
    //code adapter lắng nghe sự kiện
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    //tạo class viewholder
    class ViewHolder(itemView: View,clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    //ctrl + i
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.emp_list_item,parent,false)
        return ViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            tvEmpName.text = ds[position].empName
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}