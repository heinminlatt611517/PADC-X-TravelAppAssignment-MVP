package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.delegates.ToursItemDelegate
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.HomeView

interface HomePresenter :ToursItemDelegate, BasePresenter<HomeView> {

   fun onUiReady()
    fun onSwipeRefresh()

}