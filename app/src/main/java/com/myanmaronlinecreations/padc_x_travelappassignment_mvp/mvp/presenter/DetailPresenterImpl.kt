package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModel
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModelImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter,AbstractBasePresenter<DetailView>() {

    var mTourModel : ToursModel=ToursModelImpl

    override fun getTourByName(lifecycleOwner: LifecycleOwner, name: String) {
        mTourModel.getToursByName(name)
            .observe(lifecycleOwner, Observer {
                mView?.DisplayToursDetail(it)
            })
    }
}