package com.example.kalorie.presentation.screens.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import com.example.kalorie.presentation.screens.login.components.CardForm
import com.example.kalorie.presentation.screens.register.RegisterViewModel

@Composable
fun RegisterContent(navHostController: NavHostController, paddingValues: PaddingValues) {

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

        RegisterForm(navHostController = navHostController)
    }

}

@Composable
fun RegisterForm(
    registerViewModel: RegisterViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    Card(
        backgroundColor = Color.White
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
                text = "Sign up",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Row() {
                SmallText(
                    text = "Already registered?"
                )

                SmallText(
                    text = "Log in here.",
                    onClick = { navHostController.navigate(AppScreen.Login.route) }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            DefaultTextField(
                value = registerViewModel.name.value,
                onValueChange = { registerViewModel.name.value = it },
                placeHolder = "Name",
                validateField = { registerViewModel.validateName() },
                errorMsg = registerViewModel.nameErrorMsg.value)

            DefaultTextField(
                value = registerViewModel.email.value,
                onValueChange = { registerViewModel.email.value = it },
                placeHolder = "Email",
                keyboardType = KeyboardType.Email,
                validateField = {registerViewModel.validateEmail()},
                errorMsg = registerViewModel.emailErrorMsg.value)

            DefaultTextField(
                value = registerViewModel.password.value,
                onValueChange = { registerViewModel.password.value = it },
                placeHolder = "Password",
                hideText = true,
                validateField = { registerViewModel.validatePassword() },
                errorMsg = registerViewModel.passwordErrorMsg.value)

            DefaultTextField(
                value = registerViewModel.confirmedPassword.value,
                onValueChange = { registerViewModel.confirmedPassword.value = it },
                placeHolder = "Confirm Password",
                hideText = true,
                validateField = { registerViewModel.validateConfirmedPassword() },
                errorMsg = registerViewModel.confirmedPasswordErrorMsg.value)

            DefaultButton(
                text = "Sign up",
                onClick = { /*TODO*/ },
                errorMessage = "",
                enabled = registerViewModel.isRegisterButtonEnabled.value
            )

        }
    }
}