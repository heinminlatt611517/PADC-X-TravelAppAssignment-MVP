package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.model

import android.content.Context
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.network.ToursApi
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.db.AppDatabase
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.root.TourApp
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
 protected  var mTourApi : ToursApi

    protected lateinit var mDataBase: AppDatabase
    init {
        val okHttpClient =OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mTourApi=retrofit.create(ToursApi::class.java)
    }

    fun initModel(context: Context){
        mDataBase = AppDatabase.getDBInstance(context)
    }
}