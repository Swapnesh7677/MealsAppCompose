package com.example.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.MealsRespository
import com.example.mealzapp.model.response.Category
import com.example.mealzapp.model.response.MealCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val respository: MealsRespository = MealsRespository.getInstance()): ViewModel() {

    init{
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }

    }

    val mealsState : MutableState<List<Category>> =  mutableStateOf(emptyList<Category>())
    suspend  fun getMeals():List<Category> {
        print("viewmodel")
       return respository.getMeals().categories
    }








}