package com.example.kotlin.chapter13

import kotlinx.coroutines.*

suspend fun main() {
    GlobalScope.launch {
        val job = launch { println("test") }

        val result = fetchConfigFromServer()
        println("${Thread.currentThread().name} task A finished $result")

        val resultB = async {
            println("${Thread.currentThread().name} taskB started")
            delay(100)
            println("${Thread.currentThread().name} taskB finished 6")
            6
        }
        resultB.await()
    }
}

suspend fun fetchConfigFromServer(): Int {
    return withContext(Dispatchers.Default) {
        println("${Thread.currentThread().name} taskA started")
        Thread.sleep(1000)
        val result = 5
        result
    }
}
