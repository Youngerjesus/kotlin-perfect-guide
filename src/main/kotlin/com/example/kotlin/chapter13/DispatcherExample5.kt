package com.example.kotlin.chapter13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    coroutineScope {
        println("Root: ${Thread.currentThread().name}")

        launch {
            println("Nested, inherited: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default){
            println("Nested, explicit: ${Thread.currentThread().name}")
        }
    }
}
