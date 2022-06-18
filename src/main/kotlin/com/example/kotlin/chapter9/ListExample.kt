package com.example.kotlin.chapter9

fun main() {
    val anyListOf = listOf<Any>(123, "123", Any())
    val stringList = listOf<String>("1", "2")

    val anyList2: List<Any> = stringList

    println(anyListOf[1])
}
