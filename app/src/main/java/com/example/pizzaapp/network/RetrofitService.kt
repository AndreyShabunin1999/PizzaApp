package com.example.pizzaapp.network

import com.example.pizzaapp.model.responce.ThemealdbResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
   // @GET("/api/json/v1/1/filter.php?c=Seafood")
    //https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood
    @GET("filter.php?c=Seafood")
    fun getData(): Call<List<ThemealdbResponce>>
}