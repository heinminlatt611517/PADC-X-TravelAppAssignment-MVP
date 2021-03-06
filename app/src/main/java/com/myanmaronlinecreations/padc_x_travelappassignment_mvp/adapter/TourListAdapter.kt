package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.R
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.delegates.ToursItemDelegate
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewholder.BaseViewHolder
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewholder.ToursViewHolder

class TourListAdapter(delegate : ToursItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<CountryVO>,CountryVO>() {

    val mDelegate : ToursItemDelegate=delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tour_list_items, parent, false)
        return ToursViewHolder(mDelegate,view)
    }
}