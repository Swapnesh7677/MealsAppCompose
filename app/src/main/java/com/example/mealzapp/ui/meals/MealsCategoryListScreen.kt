package com.example.mealzapp.ui.meals

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.mealzapp.model.response.Category

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MealCategoriesScreen( navigationCallback: (String) -> Unit) {

    println("Called")
    val viewModel: MealsCategoriesViewModel =  viewModel()
    val meals = viewModel.mealsState.value

    Scaffold(topBar = { AppBar() })  {
        LazyColumn(modifier = Modifier.fillMaxSize()
            .padding(it),
            contentPadding = PaddingValues(16.dp)) {
            items(meals){meals->
                MealsCategory(meals,navigationCallback)

            }
        }
    }

}


@Composable
fun MealsCategory(meal : Category,navigationCallback: (String) -> Unit){
    var isExpanded by remember { mutableStateOf(false) }
        Card(shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .clickable {
                    navigationCallback(meal.id)
                }
        ) {
            Row(modifier = Modifier.animateContentSize()) {
                Image(painter = rememberAsyncImagePainter(model = meal.imageUrl),
                    contentDescription = null ,
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterVertically),
                )
                Column(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth(0.8f)
                    .padding(16.dp)
                ) {

                    Text(text = meal.name, style = MaterialTheme.typography.headlineSmall)

                    Text(text = meal.description,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if (isExpanded) 10 else 4
                    )
                }
                Icon(imageVector =if (isExpanded)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(
                            if (isExpanded)
                                Alignment.Bottom
                            else
                                Alignment.CenterVertically
                        )
                        .clickable { isExpanded = !isExpanded }
                )

            }

        }




}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {Icon(Icons.Default.Home,"null")},
        title = {Text("Meals App") })
}

