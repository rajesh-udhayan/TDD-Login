package com.rajesh.tddloginkata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginView()
                }
            }
        }
    }
}

@Composable
fun LoginView() {
    Text(text = "Welcome")

    OutlinedTextField(value = "", onValueChange = {

    },
    label = { Text(text = "Username")})

    OutlinedTextField(value = "", onValueChange = {

    },
        label = { Text(text = "Password")})

    Button(onClick = { }) {
        Text(text = "Login")
    }
}

@Composable
fun LoginTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = lightColors(),
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}