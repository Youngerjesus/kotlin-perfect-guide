package com.example.kotlin.chapter9

fun main() {
    val anyListOf = listOf<Any>(123, "123", Any())
    val stringList = listOf<String>("1", "2")
    println(anyListOf[1])
}
