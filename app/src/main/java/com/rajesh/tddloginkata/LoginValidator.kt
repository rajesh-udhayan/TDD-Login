package com.rajesh.tddloginkata

class LoginValidator {


    fun validateCredentials(username: String, password: String): String {
        if (username.isEmpty() && password.isEmpty()) {
            return "Empty Credentials!"
        }
        if (username.isEmpty()) {
            return "Empty Username!"
        }
        if (password.isEmpty()) {
            return "Empty Password!"
        }
        if (!username.equals("John", ignoreCase = true) && !password.equals("1234")) {
            return "Invalid Credentials!"
        }
        return ""
    }

}