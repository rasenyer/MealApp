package com.rasenyer.mealapp.ui.fragments.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rasenyer.mealapp.data.remote.models.Meal
import com.rasenyer.mealapp.data.remote.models.MealList
import com.rasenyer.mealapp.data.remote.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private var meal = MutableLiveData<Meal>()

    fun getMealById(id: String){

        RetrofitInstance.mealApi.getMealById(id).enqueue(object : Callback<MealList> {

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {

                if (response.body() != null) {
                    meal.value = response.body()!!.meals[0]
                } else {
                    return
                }

            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })

    }

    fun observerMeal(): LiveData<Meal> {
        return meal
    }

}