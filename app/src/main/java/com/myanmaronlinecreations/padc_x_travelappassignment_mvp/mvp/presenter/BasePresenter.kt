package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter

import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
   fun initPresenter(view : T)
}