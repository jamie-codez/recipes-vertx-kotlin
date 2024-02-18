package com.recipe.api.openapi


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class ApiDoc(
    val tags: Array<String> = [],
    val summary: String = "",
    val description: String = "",
    val endpoint: String = "",
    val operations: Array<RouteOperation> = []
)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class RouteOperation(
    val tags: Array<String> = [],
    val path: String = "",
    val method: String = "get",
    val summary: String = "",
    val description: String = "",
    val headers: Array<RouteParameter> = [],
    val parameters: Array<RouteParameter> = [],
    val requestBody: RouteRequestBody,
    val responses: Array<RouteResponse> = []
)


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class RouteParameter(
    val name: String,
    val description: String,
    val required: Boolean = true,
    val `in`: String = "query",
    val allowEmptyValue: Boolean = false,
    val schema: RouteParameterSchema = RouteParameterSchema()
)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class RouteParameterSchema(
    val type: String = "string",
    val format: String = "string",
    val example: String = ""
)



