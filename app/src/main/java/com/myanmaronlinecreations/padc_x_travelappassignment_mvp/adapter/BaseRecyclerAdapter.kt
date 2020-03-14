package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewholder.BaseViewHolder

abstract class BaseRecyclerAdapter<T : BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mData : MutableList<W> = arrayListOf()

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount(): Int {
       return mData.count()
    }

    fun setNewData(data : MutableList<W>){
        mData=data
        notifyDataSetChanged()
    }
    fun appendNewData(data : MutableList<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}