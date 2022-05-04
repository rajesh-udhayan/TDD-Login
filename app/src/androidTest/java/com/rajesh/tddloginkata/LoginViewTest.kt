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
    fun setUp(){
        composeTestRule.setContent {
            LoginTheme {
                LoginView()
            }
        }
    }
    @Test
    fun shouldDisplayWelcomeText() {
        val welcomeText =composeTestRule.onNodeWithText("Welcome")

        welcomeText.assertIsDisplayed()
    }

    @Test
    fun shouldDisplayUsernameTextField() {
        val usernameTextField =composeTestRule.onNodeWithText("Username")

        usernameTextField.assertIsDisplayed()
    }

    @Test
    fun shouldDisplayPasswordTextField() {
        val passwordTextField =composeTestRule.onNodeWithText("Password")

        passwordTextField.assertIsDisplayed()
    }
}