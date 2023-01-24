package com.example.kotlin.chapter13

import kotlinx.coroutines.*
import org.springframework.web.reactive.function.client.WebClient
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

val newFixedThreadPool = Executors.newFixedThreadPool(50)

suspend fun main() {
    val singleThreadExecutor = Executors.newSingleThreadExecutor()
    val time = measureTimeMillis {
        coroutineScope {
            repeat(50) {
                launch(singleThreadExecutor.asCoroutineDispatcher()) {
                    WebClient.builder()
                        .baseUrl("http://localhost:8080/analyze?query=2*3")
                        .build()
                }
            }
        }
    }
    println(time) // ~1000
//    val time2 = measureTimeMillis {
//        repeat(50) {
//            val future = newFixedThreadPool.submit {
//                println("${Thread.currentThread().name} started")
//                Thread.sleep(1000)
//                println("${Thread.currentThread().name} finished")
//            }
//        }
//    }
//
//    println(time2)
}
