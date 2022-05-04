package com.rajesh.tddloginkata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
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
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome",
            style = Typography().h3,
            modifier = Modifier.padding(20.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text(text = "Username") },
            modifier = Modifier.padding(10.dp)
        )


        OutlinedTextField(
            value = password, onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },
            modifier = Modifier.padding(5.dp)
        )

        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }


        Button(onClick = {
            val message = viewModel.login(username.text, password.text)
            scope.launch {
                snackbarHostState.showSnackbar(message, duration = SnackbarDuration.Short)
            }
        },
        modifier = Modifier.padding(10.dp)) {
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