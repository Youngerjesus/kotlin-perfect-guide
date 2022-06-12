package com.example.kotlin.chapter5

import java.util.function.Consumer

fun interface StringConsumer {
    fun accept(s: String)
}

fun measureTime(action: () -> Unit): Long {
    val startTime = System.nanoTime()
    action()
    return System.nanoTime() - startTime
}

fun check(s: String, condition: (Char) -> Boolean): Boolean {
    for (c in s) {
        if (!condition(c)) return false
    }

    return true
}

fun check2(s: String, condition: (Int, Char) -> Boolean): Boolean {
    for (i in s.indices) {
        if (!condition(i, s[i])) return false
    }

    return true
}

fun isCapitalLetter(c: Char) = c.isUpperCase() && c.isLetter()

class FunctionType {
}

fun main() {
    val consume = StringConsumer {s -> println(s)}

    val time = measureTime { 1 + 2 }

    println(check("hello") {c -> c.isLetter()})
    println(check("hello") { it.isLetter()}) // 이것도 가능

    println(check2("hello") {_, c -> c.isLetter()})

    println(check("hello") { isCapitalLetter(it)})
    println(check("hello", ::isCapitalLetter)) // 이것도 가능
}