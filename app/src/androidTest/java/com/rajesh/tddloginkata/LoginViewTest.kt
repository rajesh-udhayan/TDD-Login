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
                LoginView(LoginViewModel())
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

    @Test
    fun credentialsAreAddingCorrectly() {
        val usernameTextField = composeTestRule.onNodeWithText("Username")
        val passwordTextField = composeTestRule.onNodeWithText("Password")

        usernameTextField.performTextInput("john")
        passwordTextField.performTextInput("1234")

        assert(usernameTextField.currentText().equals("john"))
        assert(passwordTextField.currentText().equals("1234"))
    }

    @Test
    fun shouldShowEmptyCredentialsWhenUsernameAndPasswordAreEmpty() {
        val emptyCredentialsMsg = "Empty Credentials!"

        val loginButton = composeTestRule.onNodeWithText("Login")
        loginButton.performClick()

        composeTestRule.onNodeWithText(emptyCredentialsMsg).assertIsDisplayed()
    }

    @Test
    fun shouldShowLoginSuccessWhenUsernameAndPasswordAreValid() {
        val loginSuccessMsg = "Login Success!"

        val usernameTextField = composeTestRule.onNodeWithText("Username")
        val passwordTextField = composeTestRule.onNodeWithText("Password")
        val loginButton = composeTestRule.onNodeWithText("Login")

        usernameTextField.performTextInput("john")
        passwordTextField.performTextInput("1234")
        loginButton.performClick()

        composeTestRule.onNodeWithText(loginSuccessMsg).assertIsDisplayed()
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