package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.instrumentationsTest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.daos.CountryDao
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.db.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var countryDao : CountryDao
    private lateinit var db:AppDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()

       db=Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java).build()

        countryDao=db.CountryDao()
    }

    @After
    fun closeDb(){
        db.close()
    }


    @Test
    fun insertIntoDatabaseTest(){
        val countryOne = CountryVO()

        countryOne.scoresandreviews= listOf()
        countryOne.location=""
        countryOne.id=1
        countryOne.description=""
        countryOne.averagerating=0.0
        countryOne.photos= listOf()
        countryOne.name="Test"

        countryDao.insert(countryOne)

        assert(countryDao.getToursDatabyName(countryOne.name).value?.name == countryOne.name)

    }
}