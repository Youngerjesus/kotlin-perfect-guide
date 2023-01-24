package com.example.kotlin.chapter13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            println(Thread.currentThread().name + "task A")
            for (i in 0..Int.MAX_VALUE) {
                delay(100)
                println(Thread.currentThread().name + "task A" + "i: $i")
            }
        }

        launch {
            println(Thread.currentThread().name + "task B")
            for (i in 0..Int.MAX_VALUE) {
                println(Thread.currentThread().name + "task B" + "i: $i")
            }
        }
    }
}
