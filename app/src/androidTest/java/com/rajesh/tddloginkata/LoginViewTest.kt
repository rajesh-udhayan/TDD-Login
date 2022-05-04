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

    @Test
    fun shouldDisplayWelcomeText() {
        composeTestRule.setContent {
            LoginTheme {
                LoginView()
            }
        }

        val welcomeText =composeTestRule.onNodeWithText("Welcome")

        welcomeText.assertIsDisplayed()
    }
}