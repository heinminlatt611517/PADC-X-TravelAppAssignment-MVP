package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mData : T?=null

    init {
        itemView.setOnClickListener {
            mData?.let {
                onClickItem(it)
            }

        }
    }
    abstract fun bindData(data :T)

    abstract fun onClickItem(data:T)
}