package com.rajesh.tddloginkata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue

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
    Column {
        Text(text = "Welcome")

        var username by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(value = username, onValueChange = {
            username = it
        },
            label = { Text(text = "Username") })

        OutlinedTextField(value = password, onValueChange = {
            password = it
        },
            label = { Text(text = "Password") })

        Button(onClick = { }) {
            Text(text = "Login")
        }
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