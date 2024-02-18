package com.recipe.api.openapi

import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import java.io.File
import java.io.IOException

//class SwaggerGenerator {
//
//    /**
//     * Generate a Swagger JSON object.
//     * @param title The title of the API.
//     * @param description The description of the API.
//     * @param info The info of the API.
//     * @param author The author of the API.
//     * @param version The version of the API.
//     * @param servers The servers of the API.
//     * @return A JSON object representing the Swagger specification.
//     */
//    fun generateSwagger(
//        title: String,
//        description: String,
//        info: String,
//        author: JsonObject,
//        version: String,
//        servers: List<JsonObject>,
//        docPath: String? = "",
//        routeOperations: List<RouteOperation>
//    ): JsonObject {
//        val swagger = JsonObject()
//        val swaggerInfo = JsonObject.of(
//            "title", title,
//            "description", description,
//            "info", info,
//            "author", author,
//            "version", version
//        )
//        swagger.put("info", swaggerInfo)
//        swagger.put("servers", servers)
//        swagger.put("openapi", "3.0.0")
//        for (server in servers) {
//            server.put("url", server.getString("url") + docPath)
//        }
//        swagger.put("tags", JsonArray())
//        // Group operations by tags
//        groupOperationsByTags(routeOperations).forEach { (tag, operations) ->
//
//        }
//    }
//
//
//    @Throws(IOException::class)
//    private fun saveSwaggerToFile(swagger: JsonObject, path: String) {
//        try {
//            val file = File(path)
//            file.writeText(swagger.encodePrettily())
//        }catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//
//    private fun groupOperationsByTags(routeOperations: List<RouteOperation>): Map<String, List<RouteOperation>> {
//        return routeOperations.groupBy { it.tags.first() }
//    }
//}