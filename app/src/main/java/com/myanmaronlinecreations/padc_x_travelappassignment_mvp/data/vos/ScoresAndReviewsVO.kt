package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.data.vos

import com.google.gson.annotations.SerializedName

data class ScoresAndReviewsVO (
    @SerializedName("name")
    val name : String ="",
    @SerializedName("score")
    val score : Double = 0.0,
    @SerializedName("max_score")
    val max_score : Int = 0,
    @SerializedName("total_reviews")
    val total_reviews : Int = 0
)
