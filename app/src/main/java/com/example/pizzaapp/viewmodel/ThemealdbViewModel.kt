package com.example.pizzaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzaapp.model.responce.ThemealdbResponce
import com.example.pizzaapp.network.RetrofitInstance
import com.example.pizzaapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger

class ThemealdbViewModel: ViewModel() {
    //Live Data
    val themealDataList = MutableLiveData<ThemealdbResponce>()

    fun getApiData(categories: String){
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        retrofitService.getData(categories).enqueue(object : Callback<ThemealdbResponce>{
            override fun onResponse(
                call: Call<ThemealdbResponce>,
                response: Response<ThemealdbResponce>
            ) {
                //Success
                themealDataList.value = response.body()
            }

            override fun onFailure(call: Call<ThemealdbResponce>, t: Throwable) {
                //
            }

        })

    }
}