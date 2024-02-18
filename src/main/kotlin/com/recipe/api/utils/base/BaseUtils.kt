package com.recipe.api.utils.base

import io.vertx.core.impl.logging.LoggerFactory

class BaseUtils private constructor() {
    private val logger = LoggerFactory.getLogger(this::class.java.simpleName)

    companion object {
        /**
         * This is a instance of the BaseUtils object
         */
        private var instance: BaseUtils? = null

        /**
         * This method returns the instance of the BaseUtils object
         * @return BaseUtils
         */
        fun getInstance(): BaseUtils {
            return instance ?: BaseUtils().also {
                instance = it
            }
        }
    }

    /**
     * THis method is used to generate a random alphanumeric string of the specified length and prefix.
     * @param prefix This is the prefix of the random string to be generated (default is empty string)
     * @param length This is the length of the random string to be generated (default is 20)
     * @return String The random string
     */
    fun generateRandomString(prefix: String = "", length: Int = 20): String {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return if (prefix.isEmpty()) {
            (1..length)
                .map { kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("").trim()
        } else {
            "${prefix}_${
                (1..length)
                    .map { kotlin.random.Random.nextInt(0, charPool.size) }
                    .map(charPool::get)
                    .joinToString("")
            }".trim()
        }
    }


    /**
     * This method is used to generate a random alphabetic string of the specified length and prefix.
     * @param prefix This is the prefix of the random string to be generated (default is empty string)
     * @param length This is the length of the random string to be generated (default is 20)
     * @return String The random string
     */
    fun generateRandomAlphabeticString(prefix: String = "", length: Int = 20): String {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z')
        return if (prefix.isEmpty()) {
            (1..length)
                .map { kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("").trim()
        } else {
            "${prefix}_${
                (1..length)
                    .map { kotlin.random.Random.nextInt(0, charPool.size) }
                    .map(charPool::get)
                    .joinToString("")
            }".trim()
        }
    }

    /**
     * This method is used to generate a random numeric string of the specified length and prefix.
     * @param prefix This is the prefix of the random string to be generated (default is empty string)
     * @param length This is the length of the random string to be generated (default is 20)
     * @return String The random string
     */
    fun generateRandomNumericString(prefix: String = "", length: Int = 20): String {
        val charPool: CharRange = ('0'..'9')
        return if (prefix.isEmpty()) {
            (1..length)
                .map { kotlin.random.Random.nextInt(0, charPool.count()) }
                .map(charPool::elementAt)
                .joinToString("").trim()
        } else {
            "${prefix}_${
                (1..length)
                    .map { kotlin.random.Random.nextInt(0, charPool.count()) }
                    .map(charPool::elementAt)
                    .joinToString("")
            }".trim()
        }
    }


}