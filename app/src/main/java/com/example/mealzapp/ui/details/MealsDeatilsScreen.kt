package com.example.mealzapp.ui.details

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation


import com.example.mealzapp.model.response.Category
import com.example.mealzapp.ui.meals.AppBar

@Composable
fun MealsDetailsScreen(meal:Category?){
     var isExpanded by remember { mutableStateOf(false) }
    val imageSizeDp :Dp by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else 100.dp )

    Scaffold(topBar = { AppBar() })  {
        Column(modifier = Modifier.padding(it)) {
            Row{
                Card{
                    Image(
                        painter = rememberImagePainter(data = meal?.imageUrl,
                            builder = {
                                transformations(CircleCropTransformation())
                            } ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(imageSizeDp)
                            .padding(8.dp)

                    )
                }
                Text(meal?.name.toString(),
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically))
            }
            Button(modifier = Modifier
                .padding(16.dp),
                onClick = { isExpanded = !isExpanded }) {
                Text(
                    "Change stata of image"
                )
            }
        }
    }

}