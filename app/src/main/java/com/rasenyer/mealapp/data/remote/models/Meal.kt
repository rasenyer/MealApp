package com.rasenyer.mealapp.data.remote.models

import com.google.gson.annotations.SerializedName

data class Meal(

    @SerializedName("strMeal")
    val name: String,

    @SerializedName("strInstructions")
    val instructions: String,

    @SerializedName("strCategory")
    val category: String,

    @SerializedName("strArea")
    val area: String,

    @SerializedName("strMealThumb")
    val linkImage: String,

    @SerializedName("strYoutube")
    val linkVideo: String

)