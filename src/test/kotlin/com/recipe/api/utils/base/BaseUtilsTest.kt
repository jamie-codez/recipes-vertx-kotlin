package com.recipe.api.utils.base

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BaseUtilsTest {
    private var baseUtils: BaseUtils?= null

    @BeforeEach
    fun setUp() {
        this.baseUtils = BaseUtils.getInstance()
    }

    @AfterEach
    fun tearDown() {
        this.baseUtils = null
    }

    @Test
    fun generateRandomStringWithoutPrefix() {
        val randomString = this.baseUtils?.generateRandomString()
        assertNotNull(randomString)
        assertTrue(randomString!!.length == 20)
    }

    @Test
    fun generateRandomAlphabeticStringWithoutPrefix() {
        val randomAlphabeticString = this.baseUtils?.generateRandomAlphabeticString()
        assertNotNull(randomAlphabeticString)
        assertTrue(randomAlphabeticString!!.length == 20)
    }

    @Test
    fun generateRandomNumericStringWithoutPrefix() {
        val randomNumericString = this.baseUtils?.generateRandomNumericString()
        assertNotNull(randomNumericString)
        assertTrue(randomNumericString!!.length == 20)
    }

    @Test
    fun generateRandomStringWithPrefix() {
        val randomString = this.baseUtils?.generateRandomString("test")
        assertNotNull(randomString)
        assertTrue(randomString!!.length == 25)
        assertTrue(randomString.startsWith("test_"))
    }

    @Test
    fun generateRandomAlphabeticStringWithPrefix() {
        val randomAlphabeticString = this.baseUtils?.generateRandomAlphabeticString("test")
        assertNotNull(randomAlphabeticString)
        assertTrue(randomAlphabeticString!!.length == 25)
        assertTrue(randomAlphabeticString.startsWith("test_"))
    }

    @Test
    fun generateRandomNumericStringWithPrefix() {
        val randomNumericString = this.baseUtils?.generateRandomNumericString("test")
        assertNotNull(randomNumericString)
        assertTrue(randomNumericString!!.length == 25)
        assertTrue(randomNumericString.startsWith("test_"))
    }

    @Test
    fun generateRandomStringWithLength() {
        val randomString = this.baseUtils?.generateRandomString(length = 10)
        assertNotNull(randomString)
        assertTrue(randomString!!.length == 10)
    }

    @Test
    fun generateRandomAlphabeticStringWithLength() {
        val randomAlphabeticString = this.baseUtils?.generateRandomAlphabeticString(length = 10)
        assertNotNull(randomAlphabeticString)
        assertTrue(randomAlphabeticString!!.length == 10)
    }

    @Test
    fun generateRandomNumericStringWithLength() {
        val randomNumericString = this.baseUtils?.generateRandomNumericString(length = 10)
        assertNotNull(randomNumericString)
        assertTrue(randomNumericString!!.length == 10)
    }

    @Test
    fun generateRandomStringWithPrefixAndLength() {
        val randomString = this.baseUtils?.generateRandomString("test", 10)
        assertNotNull(randomString)
        assertTrue(randomString!!.length == 15)
        assertTrue(randomString.startsWith("test_"))
    }

    @Test
    fun generateRandomAlphabeticStringWithPrefixAndLength() {
        val randomAlphabeticString = this.baseUtils?.generateRandomAlphabeticString("test", 10)
        assertNotNull(randomAlphabeticString)
        assertTrue(randomAlphabeticString!!.length == 15)
        assertTrue(randomAlphabeticString.startsWith("test_"))
    }

    @Test
    fun generateRandomNumericStringWithPrefixAndLength() {
        val randomNumericString = this.baseUtils?.generateRandomNumericString("test", 10)
        assertNotNull(randomNumericString)
        assertTrue(randomNumericString!!.length == 15)
        assertTrue(randomNumericString.startsWith("test_"))
    }
}