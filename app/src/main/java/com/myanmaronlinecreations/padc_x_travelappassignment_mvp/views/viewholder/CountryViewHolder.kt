package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewholder

import android.view.TouchDelegate
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.delegates.ToursItemDelegate
import kotlinx.android.synthetic.main.popular_list_items.view.*

class CountryViewHolder(private val delegate: ToursItemDelegate,itemView: View) : BaseViewHolder<CountryVO>(itemView) {

    override fun onClickItem(data: CountryVO) {
        delegate.onTapToursItem(data.name)
    }


    override fun bindData(data: CountryVO) {
        mData=data

        Glide.with(itemView.context)
            .load(data.photos?.get(position))
            .into(itemView.iv_main_country)

        itemView.tv_country_title.text=data.name
        itemView.tv_avg_rating.text=data.averagerating.toString()
    }
}