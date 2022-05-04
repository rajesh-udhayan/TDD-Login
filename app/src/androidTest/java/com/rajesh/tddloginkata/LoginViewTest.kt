package com.rajesh.tddloginkata

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
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
                LoginView(LoginViewModel(LoginValidator()))
            }
        }
    }

    @Test
    fun shouldDisplayLoginViews() {
        with(composeTestRule) {
            val welcomeText = onNodeWithText("Welcome")
            val usernameTextField = onNodeWithText("Username")
            val passwordTextField = onNodeWithText("Password")
            val loginButton = onNodeWithText("Login")

            welcomeText.assertIsDisplayed()
            usernameTextField.assertIsDisplayed()
            passwordTextField.assertIsDisplayed()
            loginButton.assertIsDisplayed()
        }
    }

    @Test
    fun credentialsAreAddingCorrectly() {
        with(composeTestRule) {
            val usernameTextField = onNodeWithText("Username")
            val passwordTextField = onNodeWithText("Password")

            usernameTextField.performTextInput("john")
            passwordTextField.performTextInput("1234")

            assert(usernameTextField.currentText().equals("john"))
            assert(passwordTextField.currentText().equals("1234"))
        }
    }

    @Test
    fun shouldShowEmptyCredentialsWhenUsernameAndPasswordAreEmpty() {
        val emptyCredentialsMsg = "Empty Credentials!"

        with(composeTestRule) {
            val loginButton = onNodeWithText("Login")
            loginButton.performClick()

            onNodeWithText(emptyCredentialsMsg).assertIsDisplayed()
        }
    }

    @Test
    fun shouldShowLoginSuccessWhenUsernameAndPasswordAreValid() {
        val loginSuccessMsg = "Login Success!"

        with(composeTestRule) {
            val usernameTextField = onNodeWithText("Username")
            val passwordTextField = onNodeWithText("Password")
            val loginButton = onNodeWithText("Login")

            usernameTextField.performTextInput("john")
            passwordTextField.performTextInput("1234")
            loginButton.performClick()

            onNodeWithText(loginSuccessMsg).assertIsDisplayed()
        }
    }

    private fun SemanticsNodeInteraction.currentText(): String? {
        for ((key, value) in fetchSemanticsNode().config) {
            if (key.name == "EditableText") {
                return value.toString()
            }
        }
        return null
    }
}