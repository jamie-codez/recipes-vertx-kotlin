package com.recipe.api.utils.base

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ExtnFxnsKtTest {
    private lateinit var email: String
    private lateinit var phone : String
    private lateinit var password: String
    @BeforeEach
    fun setUp() {
        this.email = "test@email.com"
        this.phone = "+1234567890"
        this.password = "Test@123"
    }

    @AfterEach
    fun tearDown() {
        this.email = ""
        this.phone = ""
        this.password = ""
    }

    @Test
    fun isValidEmail() {
        assertTrue(this.email.isValidEmail())
    }

    @Test
    fun isValidPhoneNumber() {
        assertTrue(this.phone.isValidPhoneNumber())
    }

    @Test
    fun isValidPassword() {
        assertTrue(this.password.isValidPassword())
    }

    @Test
    fun isInvalidEmail() {
        this.email = "testemail.com"
        assertFalse(this.email.isValidEmail())
    }

    @Test
    fun isInvalidPhoneNumber() {
        this.phone = "1234567890"
        assertFalse(this.phone.isValidPhoneNumber())
    }

    @Test
    fun isInvalidPassword() {
        this.password = "test@123"
        assertFalse(this.password.isValidPassword())
    }
}