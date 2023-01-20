package com.example.kotlin.chapter13

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Parent task started")

        coroutineScope {  }
        launch {
            println("task A started")
            delay(200)
            println("task A finished")
        }

        launch {
            println("task B started")
            delay(200)
            println("task B finished")
        }

        delay(100)
        println("Parent task finished")
    }

    println("shutting down...")
}
