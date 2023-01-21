package com.example.kotlin.chapter13

import kotlinx.coroutines.*

suspend fun main() {
    coroutineScope {
        val jobA = launch {
            delay(1000)
            var i = 0
            while (isActive) {
                yield()
                println(i++)
            }
        }

        launch {
            println("Job A canceled")
            println("Job B completed")
        }
    }
}
