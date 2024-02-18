package com.recipe.api.utils

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

}