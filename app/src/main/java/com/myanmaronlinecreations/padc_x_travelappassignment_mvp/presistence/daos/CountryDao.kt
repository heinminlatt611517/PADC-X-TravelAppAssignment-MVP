package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.*
import androidx.room.Query
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos.CountryVO
@Dao
interface CountryDao {

    @Insert(onConflict = REPLACE)
    fun saveAllTourData(list: MutableList<CountryVO>): LongArray

    @Query("select * from country where name = :name ")
    fun getToursDatabyName(name: String): LiveData<CountryVO>

    @Query("select * from country")
    fun getAllData(): LiveData<List<CountryVO>>

}
