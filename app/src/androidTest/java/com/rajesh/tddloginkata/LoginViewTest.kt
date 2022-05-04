package com.rajesh.tddloginkata

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            LoginTheme {
                LoginView()
            }
        }
    }

    @Test
    fun shouldDisplayLoginViews() {
        val welcomeText = composeTestRule.onNodeWithText("Welcome")
        val usernameTextField = composeTestRule.onNodeWithText("Username")
        val passwordTextField = composeTestRule.onNodeWithText("Password")
        val loginButton = composeTestRule.onNodeWithText("Login")

        welcomeText.assertIsDisplayed()
        usernameTextField.assertIsDisplayed()
        passwordTextField.assertIsDisplayed()
        loginButton.assertIsDisplayed()
    }
}