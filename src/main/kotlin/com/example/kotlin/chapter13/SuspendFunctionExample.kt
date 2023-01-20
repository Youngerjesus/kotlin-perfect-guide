package com.example.kotlin.chapter13

import kotlinx.coroutines.delay

suspend fun foo() {
    println("Task started")
    delay(1000)
    println("Task finished")
}

suspend fun main() {
    foo()
    println("main: Task started")
    delay(1000)
    println("main Task finished")
}
