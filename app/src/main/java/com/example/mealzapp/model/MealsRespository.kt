package com.example.mealzapp.model

import android.health.connect.datatypes.MealType
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.Category
import com.example.mealzapp.model.response.MealCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRespository(private  val webService: MealsWebService = MealsWebService()){


    private var cahedmeals = listOf<Category>()
    suspend  fun getMeals() :MealCategoriesResponse  {

        val response = webService.getMeals()
        cahedmeals = response.categories
      return response
   }

    fun getMeal(Id:String):Category?{
      return  cahedmeals.firstOrNull {   it.id == Id }
    }

    companion object{
        private  var instance :MealsRespository?= null
        fun getInstance() = instance?: synchronized(this){
            instance ?: MealsRespository().also { instance = it }
        }
    }
}

