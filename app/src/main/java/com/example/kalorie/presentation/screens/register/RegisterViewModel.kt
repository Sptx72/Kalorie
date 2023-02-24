package com.example.kalorie.presentation.screens.register

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class RegisterViewModel @Inject constructor(): ViewModel() {

    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMsg: MutableState<String> = mutableStateOf("")

    var name: MutableState<String> = mutableStateOf("")
    var isNameValid: MutableState<Boolean> = mutableStateOf(false)
    var nameErrorMsg: MutableState<String> = mutableStateOf("")

    var confirmedPassword: MutableState<String> = mutableStateOf("")
    var isConfirmedPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var confirmedPasswordErrorMsg: MutableState<String> = mutableStateOf("")

    var isRegisterButtonEnabled: MutableState<Boolean> = mutableStateOf(false)

    fun isRegisterButtonEnabled() {
        isRegisterButtonEnabled.value = isEmailValid.value && isPasswordValid.value && isNameValid.value && isConfirmedPasswordValid.value
    }

    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrorMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrorMsg.value = "Email not valid"
        }

        isRegisterButtonEnabled()
    }

    fun validatePassword() {
        if (password.value.length > 6) {
            isPasswordValid.value =  true
            passwordErrorMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrorMsg.value = "The password must have contain 6 characters"
        }

        isRegisterButtonEnabled()
    }

    fun validateConfirmedPassword() {
        if (confirmedPassword.value.equals(password.value)) {
            isConfirmedPasswordValid.value = true
            confirmedPasswordErrorMsg.value = ""
        } else {
            isConfirmedPasswordValid.value = false
            confirmedPasswordErrorMsg.value = "The passwords doesn´t mastch"
        }

        isRegisterButtonEnabled()
    }

    fun validateName() {
        if (name.value.length > 3) {
            isNameValid.value = true
            nameErrorMsg.value = ""
        } else {
            isNameValid.value = false
            nameErrorMsg.value = "The name must have contain 3 characters"
        }

        isRegisterButtonEnabled()
    }

}