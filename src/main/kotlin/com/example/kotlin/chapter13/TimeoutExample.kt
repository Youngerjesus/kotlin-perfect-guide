package com.example.kotlin.chapter13

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.io.File

fun main() {
    runBlocking {
        try {
            val asyncData = async { File("data.txt").readText() }
            val text = withTimeout(50) { asyncData.await() }
            println(text)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
