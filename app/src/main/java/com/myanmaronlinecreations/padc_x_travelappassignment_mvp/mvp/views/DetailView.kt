package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.mvp.views

import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO

interface DetailView  : BaseView {
    fun DisplayToursDetail(country : CountryVO)
}