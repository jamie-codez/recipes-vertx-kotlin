package com.recipe.api.utils

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

class Configs private constructor() {
    companion object {
        private val instance: Configs? = null

        /**
         * Get the instance of the Configs class.
         */
        fun getInstance(): Configs {
            return instance ?: synchronized(this) {
                instance ?: Configs()
            }
        }
    }

    // Application configurations
    val appName = System.getenv("APP_NAME") ?: "Recipe API"
    val appPort = System.getenv("PORT")?.toInt() ?: 8080

    // Database configurations
    val databaseHost = System.getenv("DB_HOST") ?: "localhost"
    val databasePort = System.getenv("DB_PORT")?.toInt() ?: 5432
    val databaseName = System.getenv("DB_NAME") ?: "recipe_db"
    val databaseUser = System.getenv("DB_USER") ?: "recipe_user"
    val databasePassword = System.getenv("DB_PASSWORD") ?: "password"
    val databaseMaxPool = System.getenv("DB_MAX_POOL")?.toInt() ?: 5

    // Firebase configurations
    val firebaseCredentials = System.getenv("FIREBASE_CREDENTIALS") ?: "firebase-credentials.json"
    val firebaseDatabaseUrl = System.getenv("FIREBASE_DATABASE_URL") ?: "https://recipe-api.firebaseio.com"
    val firebaseStorageBucket = System.getenv("FIREBASE_STORAGE_BUCKET") ?: "recipe-api.appspot.com"
    val firebaseProjectId = System.getenv("FIREBASE_PROJECT_ID") ?: "recipe-api"
    val firebaseAppId = System.getenv("FIREBASE_APP_ID") ?: "1:1234567890:web:1234567890abcdef"
    val firebaseStorageMaxSize = System.getenv("FIREBASE_STORAGE_MAX_SIZE")?.toLong() ?: 10485760
    val firebaseStorageAllowedTypes = System.getenv("FIREBASE_STORAGE_ALLOWED_TYPES")?.split(",") ?: listOf("image/png", "image/jpeg", "image/jpg", "image/gif")
    val firebaseStorageCacheControl = System.getenv("FIREBASE_STORAGE_CACHE_CONTROL") ?: "public, max-age=31536000, s-maxage=31536000"
    val firebaseStorageDownloadTokens = System.getenv("FIREBASE_STORAGE_DOWNLOAD_TOKENS") ?: "1234567890"
    val firebaseStorageDefaultImage = System.getenv("FIREBASE_STORAGE_DEFAULT_IMAGE") ?: "default.png"
    val firebaseStorageDefaultImageType = System.getenv("FIREBASE_STORAGE_DEFAULT_IMAGE_TYPE") ?: "image/png"
    val firebaseStorageDefaultImageSize = System.getenv("FIREBASE_STORAGE_DEFAULT_IMAGE_SIZE")?.toLong() ?: 1024
    val firebaseStorageDefaultImageCacheControl = System.getenv("FIREBASE_STORAGE_DEFAULT_IMAGE_CACHE_CONTROL") ?: "public, max-age=31536000, s-maxage=31536000"




}