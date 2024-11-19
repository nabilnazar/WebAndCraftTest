package com.example.webandcrafttest.presentation.ui.navigation

sealed class Screen(val route: String){
    data object Home : Screen("home_screen")
    data object Cart : Screen("cart_screen")
}