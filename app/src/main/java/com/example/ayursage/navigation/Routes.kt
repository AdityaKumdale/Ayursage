package com.example.ayursage.navigation

sealed class Routes(val routes: String) {
    object Home : Routes("home")
    object Profile : Routes("profile")
    object Splash: Routes("splash")
    object Search: Routes("search")
    object  BottomNav: Routes("bottom_nav")
    object  Login: Routes("Login")
    object  Register: Routes("Register")
}