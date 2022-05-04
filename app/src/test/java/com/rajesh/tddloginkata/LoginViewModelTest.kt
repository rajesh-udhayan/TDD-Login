package com.rajesh.tddloginkata

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class LoginViewModelTest {

    @Test
    fun shouldInvokeValidateCredentialsMethodWhenLoginMethodCalled() {
        val validator = spy(LoginValidator::class.java)
        val viewModel = LoginViewModel(validator)

        viewModel.login("", "")
        verify(validator, atLeastOnce()).validateCredentials("", "")
    }
}