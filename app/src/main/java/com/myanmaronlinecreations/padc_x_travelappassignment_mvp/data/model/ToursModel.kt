package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model

import androidx.lifecycle.LiveData
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.ToursAndCountriesVO
import io.reactivex.Observable

interface ToursModel {

    fun getAllTours() : Observable<ToursAndCountriesVO>

    fun getToursByName(name : String) : LiveData<CountryVO>


}