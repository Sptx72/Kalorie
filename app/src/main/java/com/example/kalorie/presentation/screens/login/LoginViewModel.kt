package com.example.kalorie.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {

    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMessage: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMessage: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false

    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrorMessage.value = ""
        } else {
            isEmailValid.value = false
            emailErrorMessage.value = "El email no es valido"
        }

        enabledLoginButton()
    }

    fun validatePassword() {
        if (password.value.length > 6) {
            isPasswordValid.value = true
            passwordErrorMessage.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrorMessage.value = "Al menos 6 caracteres deben ser introducidos"
        }

        enabledLoginButton()
    }

    fun enabledLoginButton() {
        isEnabledLoginButton = isEmailValid.value && isPasswordValid.value
    }

}