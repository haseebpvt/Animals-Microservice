package com.example.route.general

import com.example.util.InMemoryAnimalDatabase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getAllApiList() {
    get("/") {
        call.respondText {
            """
                    GET: https://pensource.el.r.appspot.com/getAllAnimals
                    GET: https://pensource.el.r.appspot.com/getAnimal/{id}
                    
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
                            
                    GET: https://pensource.el.r.appspot.com/clear
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