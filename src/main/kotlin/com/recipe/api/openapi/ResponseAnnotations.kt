package com.recipe.api.openapi

import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class RouteResponse(
    val description: String,
    val content: Array<RouteResponseBody>
)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class RouteResponseBody(
    val contentType: String,
    val schema: KClass<*>
)