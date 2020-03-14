package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views

import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.ToursAndCountriesVO

interface HomeView : BaseView {
    fun displayToursList(toursList : ToursAndCountriesVO)
    fun hideEmptyView()
    fun showEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun nagvigateToDetail(name : String)
}