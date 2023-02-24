package com.example.kalorie.presentation.screens.login

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.kalorie.presentation.screens.login.components.LoginContent

@Composable
fun LoginScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {},
        content = {
                  LoginContent(navHostController, it)
        }
    )

}