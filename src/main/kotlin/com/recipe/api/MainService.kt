package com.recipe.api

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.http.HttpMethod.*
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.CorsHandler

class MainService(private val port: Int) : AbstractVerticle() {
    /**
     * Logger for logging purposes in this class.
     */
    private val logger = LoggerFactory.getLogger(this::class.java.simpleName)

    constructor() : this(8080)

    /**
     * Start the server and listen for incoming requests.
     */
    override fun start(startPromise: Promise<Void>) {
        val router = Router.router(vertx)


        this.vertx.createHttpServer()
            .requestHandler(router)
            .listen(port)
            .onSuccess {
                logger.info("Server started on port $port")
                startPromise.complete()
            }
            .onFailure {
                logger.error("Failed to start server on port $port", it)
                startPromise.fail(it)
            }
    }

    private fun configureMiddleWares(router: Router) {
        // Add middlewares here
        val allowedMethods = setOf(GET, POST, PUT, DELETE, OPTIONS)
        router.route().handler(BodyHandler.create())
        router.route().handler(CorsHandler.create()
            .allowedMethods(allowedMethods)
            .allowedHeader("Authorization")
            .allowedHeader("Content-Type")
            .allowedHeader("Access-Control-Allow-Method")
            .allowedHeader("Access-Control-Allow-Origin")
            .allowedHeader("Access-Control-Allow-Credentials")
            .allowedHeader("Access-Control-Allow-Headers")
            .allowedHeader("Access-Control-Max-Age")
            .allowCredentials(true))
    }

    /**
     * Stop the server and release all resources.
     */
    override fun stop(stopPromise: Promise<Void>?) {
        super.stop(stopPromise)
    }
}