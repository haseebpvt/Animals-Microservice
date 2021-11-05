package com.example.util

import com.example.model.Animal

object TestData {
    val animalList = listOf(
        Animal(animalId = 1, name = "Lino", family = "Cat", isPredator = true, age = 2, image = ""),
        Animal(animalId = 2, name = "Tiger", family = "Cat", isPredator = true, age = 2, image = ""),
        Animal(animalId = 3, name = "Zebra", family = "Unknown", isPredator = false, age = 1, image = ""),
    )
}