package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.dummy

import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.ScoresAndReviewsVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.ToursAndCountriesVO

fun getDummyTours() : ToursAndCountriesVO {
    val countryOne = CountryVO()
    countryOne.name="One"
    countryOne.photos= arrayListOf()
    countryOne.averagerating=0.0
    countryOne.description=""
    countryOne.id=1
    countryOne.location=""
    countryOne.scoresandreviews= arrayListOf()

    val countryTwo = CountryVO()
    countryOne.name="Two"
    countryOne.photos= arrayListOf()
    countryOne.averagerating=0.0
    countryOne.description=""
    countryOne.id=1
    countryOne.location=""
    countryOne.scoresandreviews= arrayListOf()

    val countryThree = CountryVO()
    countryOne.name="Three"
    countryOne.photos= arrayListOf()
    countryOne.averagerating=0.0
    countryOne.description=""
    countryOne.id=1
    countryOne.location=""
    countryOne.scoresandreviews= arrayListOf()

    return ToursAndCountriesVO()
}