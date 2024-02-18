package com.recipe.api.utils.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.storage.Storage
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.cloud.StorageClient
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessaging
import com.recipe.api.utils.Configs
import io.vertx.core.impl.logging.LoggerFactory
import java.io.File

open class RecipeFirebaseApp {
    private val logger = LoggerFactory.getLogger(RecipeFirebaseApp::class.java.name)
    private val firebaseCredentials = Configs.getInstance().firebaseCredentials
    private val firebaseDatabaseUrl = Configs.getInstance().firebaseDatabaseUrl
    private val firebaseStorageBucket = Configs.getInstance().firebaseStorageBucket
    private var firebaseInitialized = false
    private lateinit var firebaseApp: FirebaseApp
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseMessaging: FirebaseMessaging
    private lateinit var firebaseFirestore: Firestore
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var firebaseStorage: Storage

    /**
     * This is a instance of the FirebaseOptions object that is used to initialize the Firebase app with the provided credentials and database URL and storage bucket.
     * @property firebaseOptions
     */
    private val firebaseOptions = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(File(firebaseCredentials).inputStream()))
        .setDatabaseUrl(firebaseDatabaseUrl)
        .setStorageBucket(firebaseStorageBucket)
        .build()

    init {
        initializeApp()
    }

    /**
     * This method initializes the Firebase app with the provided credentials and database URL and storage bucket
     */
    private fun initializeApp() {
        try {
            if (FirebaseApp.getApps().isEmpty()) {
                this.firebaseApp = FirebaseApp.initializeApp(firebaseOptions)
                logger.info("Firebase app initialized")
            } else {
                FirebaseApp.getApps().forEach {
                    var fbInit = false
                    if (it.name == "recipe-api" || it.name == "[DEFAULT]") {
                        logger.info("Firebase app already initialized")
                        fbInit = true
                    }
                    if (!fbInit) {
                        this.firebaseApp = FirebaseApp.initializeApp(firebaseOptions)
                        logger.info("Firebase app initialized")
                    }
                    firebaseInitialized = true
                }
            }
            this.firebaseAuth = FirebaseAuth.getInstance(this.firebaseApp)
            this.firebaseMessaging = FirebaseMessaging.getInstance(this.firebaseApp)
            this.firebaseFirestore = FirestoreClient.getFirestore(this.firebaseApp)
            this.firebaseDatabase = FirebaseDatabase.getInstance(this.firebaseApp)
            this.firebaseStorage = StorageClient.getInstance(this.firebaseApp).bucket().storage
        } catch (e: Exception) {
            logger.error("Failed to initialize Firebase app", e)
        }
    }


    /**
     * Returns the instance of the FirebaseApp object
     * @return FirebaseApp
     */
    fun getFirebaseApp(): FirebaseApp {
        return this.firebaseApp
    }

    /**
     * Returns the instance of the FirebaseAuth object
     * @return FirebaseAuth
     */
    fun getFirebaseAuth(): FirebaseAuth {
        return this.firebaseAuth
    }

    /**
     * Returns the instance of the FirebaseMessaging object
     * @return FirebaseMessaging
     */
    fun getFirebaseMessaging(): FirebaseMessaging {
        return this.firebaseMessaging
    }

    /**
     * Returns the instance of the Firestore object
     * @return Firestore
     */
    fun getFirebaseFirestore(): Firestore {
        return this.firebaseFirestore
    }

    /**
     * Returns the instance of the FirebaseDatabase object
     * @return FirebaseDatabase
     */
    fun getFirebaseDatabase(): FirebaseDatabase {
        return this.firebaseDatabase
    }

    /**
     * Returns the instance of the Storage object
     * @return Storage
     */
    fun getFirebaseStorage(): Storage {
        return this.firebaseStorage
    }

    /**
     * Returns the instance of the RecipeFirebaseApp object
     * @return firebaseInitialized
     */
    fun getFirebaseInitialized(): Boolean {
        return firebaseInitialized
    }
}