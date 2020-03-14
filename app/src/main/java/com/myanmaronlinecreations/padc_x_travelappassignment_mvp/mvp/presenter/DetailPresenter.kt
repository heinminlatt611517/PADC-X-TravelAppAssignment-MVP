package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.DetailView

interface DetailPresenter : BasePresenter<DetailView> {
    fun getTourByName(lifecycleOwner: LifecycleOwner,name : String)
}