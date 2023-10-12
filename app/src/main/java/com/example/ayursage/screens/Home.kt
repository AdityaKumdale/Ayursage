package com.example.ayursage.screens

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ayursage.R
import com.example.ayursage.navigation.Routes
import com.example.ayursage.utils.SharedPref


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController:NavHostController) {
//    Scaffold(bottomBar = { MyBottomBar(navController) }) {
//            innerPadding->
//
//        NavHost(navController = navController, startDestination = Routes.Home.routes,
//            modifier = Modifier.padding(innerPadding)){
//
//            composable(route = Routes.Home.routes){
//                Home()
//            }
//
//            composable(Routes.Search.routes){
//                Search()
//            }
//
//            composable(Routes.Profile.routes){
//                Profile(navController)
//            }
//        }
    LazyColumn(){
        item {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp)
            ) {
               val (text,button,button2,button3) = createRefs()

                Text(
                    "Welcome to AyurSage",
                    modifier = Modifier.constrainAs(text) {
                        top.linkTo(parent.top, margin = 16.dp)
                    },
                    fontSize = 34.sp, // Set the desired font size here
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )


                ElevatedButton(onClick = {
                    navController.navigate(route = Routes.Login.routes)
                },modifier = Modifier.constrainAs(button){
                    top.linkTo(text.bottom)
                    //start.linkTo(parent.start)
                }) {
                    Text(text = "Logout")
                }

                ElevatedButton(onClick = {
                    navController.navigate(route = Routes.Profile.routes)
                },modifier = Modifier.constrainAs(button3){
                    top.linkTo(button2.bottom)
                    start.linkTo(parent.start)
                }) {
                    Text(text = "Profile")
                }

                ElevatedButton(onClick = {
                    navController.navigate(route = Routes.Search.routes)
                },modifier = Modifier.constrainAs(button2){
                    top.linkTo(button.bottom)
                    start.linkTo(parent.start)
                }) {
                    Text(text = "Search")
                }
            }
        }
    }
//    HomescreenFooter(onContinueClick = {
//        navController.navigate(route = Routes.Profile.routes)
//    })

}

//@Composable
//fun HomescreenFooter(onContinueClick: ()->Unit)
//{
//    Column(horizontalAlignment = Alignment.End) {
//        TextButton(onClick = onContinueClick) {
//            Text(text = "Profile")
//        }
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomescreenPreview() {
    Home(navController = rememberNavController())
}
