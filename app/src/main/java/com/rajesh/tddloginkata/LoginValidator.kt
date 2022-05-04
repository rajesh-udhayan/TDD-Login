package com.rajesh.tddloginkata

class LoginValidator {


    fun validateCredentials(username: String, password: String): String {
        val validUsername = "John"
        val validPassword = "1234"

        if (username.isEmpty() && password.isEmpty()) {
            return "Empty Credentials!"
        }
        if (username.isEmpty()) {
            return "Empty Username!"
        }
        if (password.isEmpty()) {
            return "Empty Password!"
        }
        if (!username.equals(validUsername, ignoreCase = true) && !password.equals(validPassword)) {
            return "Invalid Credentials!"
        }
        if (!username.equals(validUsername, ignoreCase = true)) {
            return "Invalid Username!"
        }
        if (!password.equals(validPassword)) {
            return "Invalid Password!"
        }
        return "Login Success!"
    }

}