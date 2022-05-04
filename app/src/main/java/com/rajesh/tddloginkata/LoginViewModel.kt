package com.rajesh.tddloginkata

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    fun login(username: String, password: String): String {
        val validator = LoginValidator()
        return validator.validateCredentials(username, password)
    }
}