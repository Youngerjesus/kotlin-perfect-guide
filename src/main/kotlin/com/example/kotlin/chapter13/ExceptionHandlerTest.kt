package com.example.kotlin.chapter13

import kotlinx.coroutines.*
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.atomic.AtomicInteger

@OptIn(DelicateCoroutinesApi::class)
suspend fun main() {
    val id = AtomicInteger()

    val executor = ScheduledThreadPoolExecutor(10) { runnable ->
        Thread(
            runnable,
            "WorkerThread-${id.incrementAndGet()}"
        ).also { it.isDaemon = true }
    }

    GlobalScope.launch {
        repeat(50) {
            launch {
                delay(1000)
                println("Task A completed " + Thread.currentThread().name)
            }
        }

        launch {
            delay(1000)
            withContext(executor.asCoroutineDispatcher()) {
                println("Task B completed " + Thread.currentThread().name)
            }
        }

        delay(1000)
        println("Root " + Thread.currentThread().name)
    }

    Thread.sleep(2000)
}
