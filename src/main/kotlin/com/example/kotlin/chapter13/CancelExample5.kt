package com.example.kotlin.chapter13

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val parentJob = launch {
            println("Parent started")

            launch {
                println("Child 1 started")
                delay(500)
                println("Child 1 completed")
            }

            launch {
                println("Child 2 started")
                delay(500)
                println("Child 2 completed")
            }

            delay(500)
            println("parent completed")
        }

        delay(100)
        parentJob.cancel()
    }
}
