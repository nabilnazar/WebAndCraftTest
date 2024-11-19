package com.example.webandcrafttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.webandcrafttest.presentation.ui.navigation.Screen
import com.example.webandcrafttest.presentation.ui.screens.CartScreen
import com.example.webandcrafttest.presentation.ui.screens.HomeScreen
import com.example.webandcrafttest.presentation.ui.theme.WebAndCraftTestTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebAndCraftTestTheme {

                val navController = rememberNavController()
                val coroutineScope = rememberCoroutineScope()

                NavHost(navController = navController, startDestination = Screen.Home.route) {
                    composable(route = Screen.Home.route) {
                        HomeScreen(
                            onCartClick = { navController.navigate(Screen.Cart.route) }
                        )
                    }

                    composable(route = Screen.Cart.route) {
                        CartScreen()
                        BackHandler {
                            navController.popBackStack() // Navigate back to HomeScreen when back is pressed on Cart screen
                        }
                    }
                }

            }
        }
    }
}
