package com.example.kotlin.chapter13

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        supervisorScope {
            val deferredA = async {
                throw Exception("Error in Task A")
                println("Task A Completed")
            }

            try {
                deferredA.await()
            } catch(e: Exception) {
                println("caught")
            }
        }

        val deferredB = async {
            println("Task B Completed")
        }

        deferredB.await()
        println("Root")
    }
}
