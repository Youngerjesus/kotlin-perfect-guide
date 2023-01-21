package com.example.kotlin.chapter13

import kotlinx.coroutines.*

suspend fun main() {
    val printer = GlobalScope.launch(Dispatchers.Default) {
        var i = 0
        while (isActive) {
            println(i++)
        }
    }

    delay(1000)
    printer.cancel()
    println("canceled")
}
