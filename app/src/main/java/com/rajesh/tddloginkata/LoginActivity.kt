package com.rajesh.tddloginkata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels {
        LoginViewModel.LoginViewModelFactory(LoginValidator())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginView(viewModel)
                }
            }
        }
    }
}

@Composable
fun LoginView(viewModel: LoginViewModel) {
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

        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }

        Button(onClick = {
            val message = viewModel.login(username.text, password.text)
            scope.launch {
                snackbarHostState.showSnackbar(message, duration = SnackbarDuration.Short)
            }
        }) {
            Text(text = "Login")
        }
        SnackbarHost(hostState = snackbarHostState)
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