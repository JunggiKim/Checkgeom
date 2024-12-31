package com.example.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

val objectMapper = jacksonObjectMapper()

inline fun <reified T> getBody(input: Map<String, *>, key: String = "body"): T {
    val bodyString = input[key] as? String ?: throw IllegalArgumentException("Key '$key' not found or not a String")
    return objectMapper.readValue(bodyString, T::class.java)
}

inline fun <reified T> getQueryStrings(input: Map<String, *>, key: String): T {
    val queryStringParameters = input["queryStringParameters"] as? Map<*, *>
     return queryStringParameters?.get(key) as T
}
