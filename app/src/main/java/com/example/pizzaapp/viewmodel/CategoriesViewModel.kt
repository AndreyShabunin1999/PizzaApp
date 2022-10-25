package com.example.pizzaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzaapp.model.responce.CategoriesResponce
import com.example.pizzaapp.network.RetrofitInstance
import com.example.pizzaapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesViewModel: ViewModel() {
    //Live Data
    val categoriesDataList = MutableLiveData<CategoriesResponce>()

    fun getApiData() {
        val retrofitService =
            RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        retrofitService.getDataCat().enqueue(object : Callback<CategoriesResponce> {
            override fun onResponse(
                call: Call<CategoriesResponce>,
                response: Response<CategoriesResponce>
            ) {
                //Success
                categoriesDataList.value = response.body()
            }

            override fun onFailure(call: Call<CategoriesResponce>, t: Throwable) {
                //
            }

        })
    }
}