package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country")
data class CountryVO (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    @SerializedName("name")
    var name : String = "",
    @SerializedName("description")
    var description : String = "",
    @SerializedName("location")
    var location : String = "",
    @SerializedName("average_rating")
    var averagerating : Double = 0.0,
    @SerializedName("scores_and_reviews")
    var scoresandreviews : List<ScoresAndReviewsVO> = listOf(),
    @SerializedName("photos")
    var photos : List<String> = listOf()
){

}
