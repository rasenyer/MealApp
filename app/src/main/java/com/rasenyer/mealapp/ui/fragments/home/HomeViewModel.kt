package com.rasenyer.mealapp.ui.fragments.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rasenyer.mealapp.data.remote.models.Category
import com.rasenyer.mealapp.data.remote.models.CategoryList
import com.rasenyer.mealapp.data.remote.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {

    private var seafoodCategoryList = MutableLiveData<List<Category>>()
    private var vegetarianCategoryList = MutableLiveData<List<Category>>()
    private var dessertCategoryList = MutableLiveData<List<Category>>()

    fun getSeafoodCategoryList(category: String) {

        RetrofitInstance.mealApi.getSeafoodCategoryList(category).enqueue(object : Callback<CategoryList> {

            override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {

                if (response.body() != null) {
                    seafoodCategoryList.value = response.body()!!.meals
                }

            }

            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })

    }

    fun observeSeafoodCategoryList(): LiveData<List<Category>> {
        return seafoodCategoryList
    }


    fun getVegetarianCategoryList(category: String) {

        RetrofitInstance.mealApi.getVegetarianCategoryList(category).enqueue(object : Callback<CategoryList> {

            override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {

                if (response.body() != null) {
                    vegetarianCategoryList.value = response.body()!!.meals
                }

            }

            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })

    }

    fun observeVegetarianCategoryList(): LiveData<List<Category>> {
        return vegetarianCategoryList
    }


    fun getDessertCategoryList(category: String) {

        RetrofitInstance.mealApi.getDessertCategoryList(category).enqueue(object : Callback<CategoryList> {

            override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {

                if (response.body() != null) {
                    dessertCategoryList.value = response.body()!!.meals
                }

            }

            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })

    }

    fun observeDessertCategoryList(): LiveData<List<Category>> {
        return dessertCategoryList
    }

}