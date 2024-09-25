package com.example.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealsRespository
import com.example.mealzapp.model.response.Category
import com.example.mealzapp.model.response.MealCategoriesResponse

class MealDetailsViewModel(private  val savedStateHandle:SavedStateHandle,

):ViewModel() {
    private val respository: MealsRespository = MealsRespository.getInstance()
    var mealState = mutableStateOf<Category?>(null)
    init {
        val mealId = savedStateHandle.get<String>("meal_cat_id")?:""
        mealState.value = respository.getMeal(mealId)
    }
}