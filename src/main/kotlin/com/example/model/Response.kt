package com.example.model

data class Response(
    val success: Int,
    val statusCode: Int,
    val message: String,
    val data: Any?
)