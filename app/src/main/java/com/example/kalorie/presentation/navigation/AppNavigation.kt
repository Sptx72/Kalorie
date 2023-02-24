package com.example.kalorie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kalorie.presentation.screens.login.LoginScreen
import com.example.kalorie.presentation.screens.register.RegisterScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {

    NavHost(navController = navHostController,
        startDestination = AppScreen.Login.route ) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(navHostController)
        }

        composable(route = AppScreen.Register.route) {
            RegisterScreen(navHostController)
        }
    }

}