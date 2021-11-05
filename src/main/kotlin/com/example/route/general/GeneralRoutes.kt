package com.example.route.general

import com.example.util.InMemoryAnimalDatabase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getAllApiList() {
    get("/") {
        call.respondText {
            """
                    GET: /getAllAnimals
                    GET: /getAnimal/{id}
                    
                    POST: /saveAnimal
                        Example input JSON:
                             {
                                "animalId": 1,
                                "name": "Lion",
                                "family": "Cat",
                                "isPredator": true,
                                "age": 1,
                                "image": "#"
                            }
                            
                    GET: /clear
                """.trimIndent()
        }
    }
}

fun Route.clear() {
    get("/clear") {
        InMemoryAnimalDatabase.clear()
        call.respond("Done")
    }
}