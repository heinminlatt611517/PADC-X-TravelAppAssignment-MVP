package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter

import androidx.lifecycle.ViewModel
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.BaseView
import kotlin.time.measureTimedValue

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T> ,ViewModel(){
    var mView : T? =null
    override fun initPresenter(view: T) {
        mView=view
    }
}