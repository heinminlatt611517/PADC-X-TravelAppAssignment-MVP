package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.db

import android.content.Context
import androidx.room.*
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.daos.CountryDao
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.typeconverters.PhotoTypeConverter
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.typeconverters.TourTypeConverter

@Database(entities = [CountryVO::class],version = 1,exportSchema = false)
@TypeConverters(TourTypeConverter::class,PhotoTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object{
        val DB_NAME="COUNTRY.DB"
        var dbInstance : AppDatabase? =null

        fun getDBInstance(context: Context) : AppDatabase{
            when(dbInstance){
                null-> {
                    dbInstance=Room.databaseBuilder(context,AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i= dbInstance
            return i!!
        }
    }

    abstract fun CountryDao() : CountryDao
}