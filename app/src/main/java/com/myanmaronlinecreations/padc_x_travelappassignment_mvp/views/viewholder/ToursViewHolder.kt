package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.delegates.ToursItemDelegate
import kotlinx.android.synthetic.main.tour_list_items.view.*

class ToursViewHolder(private val delegate : ToursItemDelegate,itemView: View) : BaseViewHolder<CountryVO>(itemView) {
    override fun onClickItem(data: CountryVO) {
        delegate.onTapToursItem(data.name)
    }

    override fun bindData(data: CountryVO) {
     mData=data
        Glide.with(itemView.context)
            .load(data.photos?.get(0))
            .into(itemView.iv_popular_tour)

        itemView.txt_country_title.text=data.name
        itemView.rating.text=data.averagerating.toString()
    }
}