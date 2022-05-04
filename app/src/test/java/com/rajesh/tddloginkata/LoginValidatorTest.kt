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
}