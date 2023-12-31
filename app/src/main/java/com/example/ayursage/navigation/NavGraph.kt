package com.example.ayursage.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ayursage.screens.BottomNav

import com.example.ayursage.screens.Home
import com.example.ayursage.screens.Login
import com.example.ayursage.screens.Profile
import com.example.ayursage.screens.Register
import com.example.ayursage.screens.Search
import com.example.ayursage.screens.Splash

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Splash.routes){
        composable(Routes.Splash.routes){
            Splash(navController)
        }

        composable(Routes.Home.routes){
            Home()
        }

        composable(Routes.Profile.routes){
            Profile(navController)
        }

        composable(Routes.Search.routes){
            Search()
        }

        composable(Routes.BottomNav.routes){
            BottomNav(navController)
        }

        composable(Routes.Login.routes){
            Login(navController)
        }

        composable(Routes.Register.routes){
            Register(navController)
        }
    }
}