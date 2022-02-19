package com.rasenyer.mealapp.data.remote.api

import com.rasenyer.mealapp.data.remote.models.CategoryList
import com.rasenyer.mealapp.data.remote.models.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET("filter.php?")
    fun getSeafoodCategoryList(@Query("c") categoryName: String): Call<CategoryList>

    @GET("filter.php?")
    fun getVegetarianCategoryList(@Query("c") categoryName: String): Call<CategoryList>

    @GET("filter.php?")
    fun getDessertCategoryList(@Query("c") categoryName: String): Call<CategoryList>

    @GET("lookup.php?")
    fun getMealById(@Query("i") id: String): Call<MealList>

}