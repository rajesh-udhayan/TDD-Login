package com.rajesh.tddloginkata

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class LoginValidatorTest {

    private lateinit var validator: LoginValidator

    @Before
    fun setUp() {
        validator = LoginValidator()
    }

    @Test
    fun `should return empty credetntials when username and password are empty`() {
        val message = validator.validateCredentials("", "")

        assertThat(message).isEqualTo("Empty Credentials!")
    }

    @Test
    fun `should return empty username when username is empty but password is not empty`() {
        val message = validator.validateCredentials("", "123")

        assertThat(message).isEqualTo("Empty Username!")
    }

    @Test
    fun `should return empty password when password is empty but username is not empty`() {
        val message = validator.validateCredentials("John", "")

        assertThat(message).isEqualTo("Empty Password!")
    }

    @Test
    fun `should return invalid credentials when username and password is not valid`() {
        val message = validator.validateCredentials("Jon", "123")

        assertThat(message).isEqualTo("Invalid Credentials!")
    }
}