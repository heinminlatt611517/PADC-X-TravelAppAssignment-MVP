package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.ToursAndCountriesVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.db.AppDatabase
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.root.TourApp.Companion.context
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object ToursModelImpl : ToursModel,BaseModel() {


    private val countries = mTourApi.getAllCountries().map { it.data }
    private val tours = mTourApi.getAllTours().map { it.data }

    @SuppressLint("CheckResult")
    override fun getAllTours(): Observable<ToursAndCountriesVO> {
        return Observable.zip<List<CountryVO>,List<CountryVO>,ToursAndCountriesVO>(
            countries, tours, BiFunction { t1, t2 ->
                t1.forEach {
                    Log.d("Tours", it.toString())
                }
                return@BiFunction ToursAndCountriesVO(t1,t2)
            }
        ).doOnNext {
            val countriesAndToursList = arrayListOf(it.country,it.tours)
                .flatten()
            mDataBase.CountryDao().saveAllTourData(countriesAndToursList.toMutableList())
        }
            .subscribeOn(Schedulers.io())
    }

    override fun getToursByName(name: String): LiveData<CountryVO> {
        return mDataBase.CountryDao().getToursDatabyName(name)
    }
}