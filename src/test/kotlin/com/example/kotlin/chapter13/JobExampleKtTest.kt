package com.example.kotlin.chapter13

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class JobExampleKtTest { 
    
    @Test
    fun `job lazy test`() {
        runBlocking {
            val job = launch(start = CoroutineStart.LAZY) {
                println("Job started")
            }

            delay(100)

            println("Preparing to start...")
            job.start()
        }
    }
    
    @Test
    fun `job status test`() {
        runBlocking {
            val job = coroutineContext[Job.Key]!!

            val jobA = launch {
                println("This is task A ")
            }

            val jobB = launch {
                println("This is task B ")
            }

            delay(100)

            println("${job.children.count()} children running")

            println("JobA isActive: ${jobA.isActive}")
            println("JobA isCompleted: ${jobA.isCompleted}")
        }
    }

    @Test
    fun `job status test2`() {
        runBlocking {
            val parentJob = launch {
                launch {
                    delay(100)
                    println("This is task C")
                }

                launch {
                    delay(100)
                    println("This is task D")
                }
            }

            println("ParentJob isActive: ${parentJob.isActive}")
            println("ParentJob isCompleted: ${parentJob.isCompleted}")
            println("ParentJob isCancelled: ${parentJob.isCancelled}")
        }
    }

    @Test
    fun `job join test`() {
        runBlocking {
            val job = coroutineContext[Job.Key]!!

            val jobA = launch { println("This is task A") }
            val jobB = launch { println("This is task B") }

            jobA.join()
            jobB.join()

            println("${job.children.count()} children running")
        }
    }
}
