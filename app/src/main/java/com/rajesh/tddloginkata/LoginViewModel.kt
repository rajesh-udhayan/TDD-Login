package com.rajesh.tddloginkata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginViewModel(private val validator: LoginValidator) : ViewModel() {

    fun login(username: String, password: String): String {
        return validator.validateCredentials(username, password)
    }

    class LoginViewModelFactory(private val loginValidator: LoginValidator) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(loginValidator) as T
        }
    }
}