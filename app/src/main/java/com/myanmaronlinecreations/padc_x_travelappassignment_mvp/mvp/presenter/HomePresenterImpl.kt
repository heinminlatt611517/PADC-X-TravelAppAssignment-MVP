package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModel
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModelImpl
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views.HomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo

class HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {

    private val mTourModel : ToursModel=ToursModelImpl


    override fun onUiReady() {
      getAllTourData()
    }

    override fun onSwipeRefresh() {
     getAllTourData()
    }

    override fun onTapToursItem(name: String) {
        mView?.nagvigateToDetail(name)
    }

    private fun getAllTourData(){
        mView?.hideEmptyView()
        mView?.enableSwipeRefresh()
        mTourModel.getAllTours()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                mView?.disableSwipeRefresh()
                mView?.displayToursList(it)
            }


    }
}