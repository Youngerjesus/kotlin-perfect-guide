package com.example.kotlin.chapter5

fun main() {
    val args = listOf(1,2,3,4,5)
    val index = readLine()?.toInt()

    val arg = index?.let { args.getOrNull(it) }

    val arg2 = index?.run { args.getOrNull(this) }

    println("arg: $arg, arg2: $arg2")
}
