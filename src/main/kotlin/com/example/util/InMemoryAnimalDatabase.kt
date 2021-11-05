package com.example.util

import com.example.model.Animal

object InMemoryAnimalDatabase {

    private val data = mutableSetOf<Pair<Int, Animal>>()

    fun addData(value: Animal): Boolean {
        val nextId = getNextId()
        return data.add(nextId to value)
    }

    fun getData(id: Int): Any? {
        return data.firstOrNull {
            it.first == id
        }?.second
    }

    fun getAllAnimals(): List<Animal> {
        val animalList = data.map {
            it.second
        }

        return animalList
    }

    fun clear() {
        data.clear()
    }

    private fun getNextId(): Int {
        return data.maxByOrNull {
            it.first
        }?.first?.plus(1) ?: 0
    }
}