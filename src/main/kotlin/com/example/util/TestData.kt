package com.example.util

import com.example.model.Animal

object TestData {
    val animalList = listOf(
        Animal(name = "Lino", family = "Cat", isPredator = true, age = 2, image = ""),
        Animal(name = "Tiger", family = "Cat", isPredator = true, age = 2, image = ""),
        Animal(name = "Zebra", family = "Unknown", isPredator = false, age = 1, image = ""),
    )
}