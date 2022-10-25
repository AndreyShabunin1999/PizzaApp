package com.example.pizzaapp.model.responce

data class ThemealdbResponce(
    val meals: List<Meals>?
)

data class Meals (
    val strMeal: String?,
    val strMealThumb: String?,
    val idMeal: String?)
