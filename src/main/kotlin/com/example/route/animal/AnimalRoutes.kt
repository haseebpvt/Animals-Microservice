package com.example.route.animal

import com.example.model.Animal
import com.example.util.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getAnimalById() {
    get("/getAnimal/{id}") {
        // Get id from request
        val id = call.parameters["id"]?.toIntOrNull() ?: call.respond(
            jsonResponse(
                success = FAILURE,
                statusCode = HttpStatusCode.NotFound.value,
                message = "Invalid id: ${call.parameters["id"]}",
                response = null
            )
        ).run { return@get }

        // Get animal with the corresponding id from in-memory database
        val data = InMemoryAnimalDatabase.getData(id) as? Animal

        if (data != null) {
            call.respond(
                jsonResponse(
                    success = SUCCESS,
                    statusCode = HttpStatusCode.OK.value,
                    message = "Success",
                    response = data
                )
            )
        } else {
            call.respond(
                jsonResponse(
                    success = FAILURE,
                    statusCode = HttpStatusCode.NotFound.value,
                    message = "Animal not found",
                    response = null
                )
            )
        }
    }
}

fun Route.saveAnimal() {
    post("/saveAnimal") {
        val animalJson = call.receive<String>()
        val animal = gson.fromJson(animalJson, Animal::class.java)
        if (InMemoryAnimalDatabase.addData(animal)) {
            call.respond(
                jsonResponse(
                    success = SUCCESS,
                    HttpStatusCode.OK.value,
                    message = "${animal.name} saved with id: ${animal.animalId}",
                    null
                )
            )
        } else {
            call.respond(
                jsonResponse(
                    success = FAILURE,
                    statusCode = HttpStatusCode.BadRequest.value,
                    message = "Animal already exists with the same id",
                    response = null
                )
            )
        }
    }
}

fun Route.getAllAnimals() {
    get("/getAllAnimals") {
        val list = InMemoryAnimalDatabase.getAllAnimals()
        if (list.isEmpty()) {
            call.respond(
                jsonResponse(
                    success = FAILURE,
                    statusCode = HttpStatusCode.NotFound.value,
                    message = "Animal list is empty",
                    list
                )
            )
        } else {
            call.respond(
                jsonResponse(
                    success = SUCCESS,
                    statusCode = HttpStatusCode.OK.value,
                    message = "Success",
                    list
                )
            )
        }
    }
}

fun Route.getImage() {
    get("/search/{term}") {
        val term = call.parameters["term"]
        val search = "https://yandex.com/images/search?text=$term"
        println("Search URL: $search")

        val imageLinkUtil = ImageLinkUtil()
        val documentText = imageLinkUtil.getDocumentString(search)
        val url = imageLinkUtil.getUrlFromDuckDuckGoImagesHtml(documentText)
        call.respondText(url)
    }
}