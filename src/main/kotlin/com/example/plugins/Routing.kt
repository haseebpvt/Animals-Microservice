package com.example.plugins

import com.example.route.animal.getAllAnimals
import com.example.route.animal.getAnimalById
import com.example.route.animal.getImage
import com.example.route.animal.saveAnimal
import com.example.route.general.clear
import com.example.route.general.getAllApiList
import io.ktor.application.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {
        // General
        getAllApiList()

        // Animal
        getAnimalById()
        getAllAnimals()
        saveAnimal()
        clear()

        // Search
        getImage()
    }
}