package com.example.plugins

import com.example.util.SUCCESS
import com.example.util.TestData
import com.example.util.jsonResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {
        get("/getAnimalList") {
            val animal = jsonResponse(SUCCESS, HttpStatusCode.OK.value, "Success", TestData.animalList)
            call.respond(animal)
        }
    }
}