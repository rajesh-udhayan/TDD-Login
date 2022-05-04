package com.rajesh.tddloginkata

class LoginValidator {

    fun validateCredentials(username: String, password: String): String {
        if (username.isEmpty() && !password.isEmpty()){
            return "Empty Username!"
        }
        if (!username.isEmpty() && password.isEmpty()) {
            return "Empty Password!"
        }
        return "Empty Credentials!"
    }

}