package com.example.kotlin.chapter13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    // go to CancelExampleTst
    val printer = GlobalScope.launch(Dispatchers.Default) {
        var i = 0
        while (true) {
            println(i++)
        }
    }

    delay(1000)
    printer.cancel()
    println("canceled")
}
