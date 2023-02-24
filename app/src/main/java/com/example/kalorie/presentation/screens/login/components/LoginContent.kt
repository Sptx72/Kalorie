package com.example.kalorie.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kalorie.R
import com.example.kalorie.presentation.components.DefaultButton
import com.example.kalorie.presentation.components.DefaultTextField
import com.example.kalorie.presentation.components.SmallText
import com.example.kalorie.presentation.navigation.AppScreen
import com.example.kalorie.presentation.screens.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LoginContent(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    loginViewModel: LoginViewModel = hiltViewModel()) {

    Column(
        modifier = Modifier
            .background(Color.Black, RectangleShape)
            .fillMaxHeight()
            .padding(paddingValues = paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(50.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo app",
        )

        CardForm(navHostController = navHostController, loginViewModel = loginViewModel)
    }
}

@Composable
fun CardForm(
    loginViewModel: LoginViewModel,
    navHostController: NavHostController) {

    Card(
        backgroundColor = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 60.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Login",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            SmallText(text = "Sign in to continue.")

            Spacer(modifier = Modifier.height(30.dp))

            DefaultTextField(
                value = loginViewModel.email.value,
                onValueChange = {
                    loginViewModel.email.value = it

                                },
                placeHolder = "Email",
                keyboardType = KeyboardType.Email,
                errorMsg = loginViewModel.emailErrorMessage.value,
                validateField = {loginViewModel.validateEmail()}
            )

            DefaultTextField(
                value = loginViewModel.password.value,
                onValueChange = { loginViewModel.password.value = it },
                placeHolder = "Password",
                hideText = true,
                errorMsg = loginViewModel.passwordErrorMessage.value,
                validateField = {loginViewModel.validatePassword()}
            )

            Spacer(modifier = Modifier.height(20.dp))

            DefaultButton(
                text = "Log in",
                onClick = {},
                errorMessage = "",
                enabled = loginViewModel.isEnabledLoginButton)

            Spacer(modifier = Modifier.height(20.dp))

            SmallText(text = "Forgot password?")

            SmallText(
                text = "Sign up!",
                onClick = { navHostController.navigate(AppScreen.Register.route) })
        }
    }
}