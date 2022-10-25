package com.example.pizzaapp.network

import com.example.pizzaapp.model.responce.ThemealdbResponce
import com.example.pizzaapp.model.responce.CategoriesResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("categories.php")
    fun getDataCat(): Call<CategoriesResponce>

    @GET("filter.php?c")
    fun getData(@Query("c") categories: String) : Call<ThemealdbResponce>

    //@GET("filter.php?c=Seafood")
    //fun getData(categories: String): Call<ThemealdbResponce>
}