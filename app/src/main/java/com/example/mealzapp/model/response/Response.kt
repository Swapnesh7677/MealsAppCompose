package com.example.mealzapp.model.response

import com.google.gson.annotations.SerializedName

data class MealCategoriesResponse(
    val categories: List<Category>,
)

data class Category(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val imageUrl: String,
    @SerializedName("strCategoryDescription")
    val description: String,
)