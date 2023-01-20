package com.example.kotlin.chapter13

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("Background Task: ${Thread.currentThread().name}")
    }

    runBlocking {
        println("Primary Task: ${Thread.currentThread().name}")
        delay(2000)
    }
}
