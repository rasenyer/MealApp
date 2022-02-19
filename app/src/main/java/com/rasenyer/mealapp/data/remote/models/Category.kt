package com.rasenyer.mealapp.data.remote.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(

    @SerializedName("idMeal")
    val id: String,

    @SerializedName("strMeal")
    val name: String,

    @SerializedName("strMealThumb")
    val url: String

): Serializable