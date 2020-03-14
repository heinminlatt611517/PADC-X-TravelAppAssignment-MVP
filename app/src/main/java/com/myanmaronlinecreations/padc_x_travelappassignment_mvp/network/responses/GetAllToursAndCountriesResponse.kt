package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.network.responses

import com.google.gson.annotations.SerializedName
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO

data class GetAllCountriesResponse(
    @SerializedName("code")
    val code : Int = 0,
    @SerializedName("message")
    val message : String = "",
    @SerializedName("data")
    val data : List<CountryVO>
)

data class GetAllToursResponse(
    @SerializedName("code")
    val code : Int = 0,
    @SerializedName("message")
    val message : String = "",
    @SerializedName("data")
    val data : List<CountryVO>
)