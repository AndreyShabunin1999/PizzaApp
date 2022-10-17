package com.example.pizzaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzaapp.model.responce.ThemealdbResponce
import com.example.pizzaapp.network.RetrofitInstance
import com.example.pizzaapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThemealdbViewModel: ViewModel() {
    //Live Data
    var themealDataList = MutableLiveData<List<ThemealdbResponce>>()

    fun getApiData(){
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        retrofitService.getData().enqueue(object : Callback<List<ThemealdbResponce>>{
            override fun onResponse(
                call: Call<List<ThemealdbResponce>>,
                response: Response<List<ThemealdbResponce>>
            ) {
                //Success
                themealDataList.value = response.body()
            }

            override fun onFailure(call: Call<List<ThemealdbResponce>>, t: Throwable) {
                //
            }

        })

    }
}