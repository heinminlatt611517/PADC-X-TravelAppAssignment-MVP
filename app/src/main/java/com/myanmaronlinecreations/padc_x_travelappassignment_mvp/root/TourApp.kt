package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.root

import android.app.Application
import android.content.Context
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model.ToursModelImpl

class TourApp : Application(){
    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext

        //initialize database
        ToursModelImpl.initModel(applicationContext)
    }
}