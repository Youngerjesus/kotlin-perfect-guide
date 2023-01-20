package com.example.kotlin.chapter13

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

fun main() {
    val coroutineScopeTimeInMills = measureTimeMillis {
        demoWithCoroutineScope()
    }

    println("coroutineScopeTimeInMills = $coroutineScopeTimeInMills")
}

val context = Executors.newFixedThreadPool(2).asCoroutineDispatcher()
fun demoWithCoroutineScope() = runBlocking {
    (1..10).forEach {
        launch(context) {
            coroutineScope {
                println("Start No.$it in coroutineScope on ${Thread.currentThread().name}")
                delay(500)
                println("End No.$it in coroutineScope on ${Thread.currentThread().name}")
            }
        }
    }
}
