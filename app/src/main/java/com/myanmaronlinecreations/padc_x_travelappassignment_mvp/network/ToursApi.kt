package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.network

import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.network.responses.GetAllCountriesResponse
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.network.responses.GetAllToursResponse
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.utils.GET_ALL_COUNTRIES
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.utils.GET_ALL_TOURS
import io.reactivex.Observable
import retrofit2.http.GET

interface ToursApi {

    @GET(GET_ALL_COUNTRIES)
    fun getAllCountries() : Observable<GetAllCountriesResponse>

    @GET(GET_ALL_TOURS)
    fun getAllTours() : Observable<GetAllToursResponse>

}