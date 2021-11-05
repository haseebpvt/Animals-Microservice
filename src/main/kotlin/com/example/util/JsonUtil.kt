package com.example.util

import com.example.model.Response
import com.google.gson.Gson

val gson by lazy { Gson() }

const val SUCCESS = 1
const val FAILURE = 0

fun jsonResponse(
    success: Int,
    statusCode: Int,
    message: String,
    response: Any?
): String {
    return gson.toJson(Response(success, statusCode, message, response))
}