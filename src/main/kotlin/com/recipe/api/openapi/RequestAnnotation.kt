package com.recipe.api.openapi

import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class RouteRequestBody(
    val description: String,
    val required: Boolean = true,
    val content: RequestBodyContent
)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class RequestBodyContent(
    val contentType: String,
    val schema: KClass<*>
)