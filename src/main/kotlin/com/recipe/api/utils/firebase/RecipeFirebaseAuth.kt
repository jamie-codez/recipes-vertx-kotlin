package com.recipe.api.utils.firebase

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseToken
import com.google.firebase.auth.SessionCookieOptions
import org.slf4j.LoggerFactory
import java.util.logging.Logger

class RecipeFirebaseAuth private constructor() : RecipeFirebaseApp() {
    /**
     * This is a logger for logging the events and errors
     */
    private val logger = LoggerFactory.getLogger(this::class.java.simpleName)

    companion object {
        /**
         * This is a instance of the RecipeFirebaseAuth object
         */
        private var instance: RecipeFirebaseAuth? = null

        /**
         * This method returns the instance of the RecipeFirebaseAuth object
         * @return RecipeFirebaseAuth
         */
        fun getInstance(): RecipeFirebaseAuth {
            return instance ?: RecipeFirebaseAuth().also {
                instance = it
            }
        }
    }

    /**
     * This method is used to verify firebase id token.
     * @param idToken This is the id token that is to be verified
     * @return FirebaseToken The decode token.
     */
    fun verifyIdToken(idToken: String, checkRevoked: Boolean = true): FirebaseToken {
        try {
            val decodedToken = this.getFirebaseAuth().verifyIdToken(idToken, checkRevoked)
            logger.info("Successfully verified id token")
            return decodedToken
        } catch (e: FirebaseException) {
            logger.error("Failed to verify id token", e)
            throw e
        }
    }

    /**
     * This method is used to create a custom token
     * @param uid This is the uid of the user for which the custom token is to be created
     * @param developerClaim This is the custom claims that are to be added to the custom token
     * @return String The custom token
     */
    fun createCustomToken(uid: String, developerClaim: Map<String, String>): String {
        try {
            val customToken = this.getFirebaseAuth().createCustomToken(uid, developerClaim)
            logger.info("Successfully created custom token")
            return customToken
        } catch (e: FirebaseException) {
            logger.error("Failed to create custom token", e)
            throw e
        }
    }

    /**
     * This method is used to verify custom cookie token.
     * @param cookie This is the cookie token that is to be verified
     * @param checkRevoked This is a boolean value that is used to check if the token is revoked or not
     * @return FirebaseToken The decode token.
     */
    fun verifyCustomCookie(cookie: String, checkRevoked: Boolean = true): FirebaseToken {
        try {
            val decodedToken = this.getFirebaseAuth().verifySessionCookie(cookie, checkRevoked)
            logger.info("Successfully verified custom cookie token")
            return decodedToken
        } catch (e: FirebaseException) {
            logger.error("Failed to verify custom cookie token", e)
            throw e
        }
    }

    /**
     * This method is used to create custom cookie token for the user using uid and the expiration time
     * @param uid This is the uid of the user for which the custom cookie token is to be created
     * @param expiresIn This is the expiration time of the custom cookie token
     * @return String The custom cookie token
     */
    fun createCustomCookie(uid: String, expiresIn: Long): String {
        try {
            val cookieOptions = SessionCookieOptions.builder()
                .setExpiresIn(expiresIn)
                .build()
            val customCookie = this.getFirebaseAuth().createSessionCookie(uid, cookieOptions)
            logger.info("Successfully created custom cookie token")
            return customCookie
        } catch (e: FirebaseException) {
            logger.error("Failed to create custom cookie token", e)
            throw e
        }
    }


    /**
     * This method is used to revoke the refresh token of the user
     * @param uid This is the uid of the user for which the refresh token is to be revoked
     * @return Boolean This returns true if the refresh token is revoked successfully
     */
    fun revokeRefreshTokens(uid: String): Boolean {
        try {
            this.getFirebaseAuth().revokeRefreshTokens(uid)
            logger.info("Successfully revoked refresh token")
            return true
        } catch (e: FirebaseException) {
            logger.error("Failed to revoke refresh token", e)
            throw e
        }
    }


    /**
     * This method is used to create user with username, email and password
     * @param uid This is the uid of the user to be created.
     * @param email This is the email of the user to be created.
     */


}