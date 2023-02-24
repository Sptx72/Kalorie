package com.example.kalorie.presentation.screens.register

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.kalorie.presentation.screens.register.components.RegisterContent

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {},
        content = {
                  RegisterContent(navHostController = navHostController, paddingValues = it)
        },
        bottomBar = {})

}

