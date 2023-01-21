package com.example.kotlin.chapter13

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val id = AtomicInteger(0)

    val executor = ScheduledThreadPoolExecutor(10) { runnable ->
        Thread(
            runnable,
            "WorkerThread-${id.incrementAndGet()}"
        ).also { it.isDaemon = true }
    }

    executor.asCoroutineDispatcher().use { dispatcher ->
        runBlocking {
            val time = System.currentTimeMillis()
            for (i in 1..10) {
                launch (dispatcher) {
                    delay(1000)
                    println(Thread.currentThread().name + " i: $i " + "${System.currentTimeMillis() - time}ms")
                }
            }
        }
    }
}
