package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.presistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoTypeConverter {
    @TypeConverter
    fun fromList(list: List<String>?): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toList(data: String?): List<String>? {
        if (data == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {

        }.type
        return gson.fromJson<List<String>>(data, type)
    }
}