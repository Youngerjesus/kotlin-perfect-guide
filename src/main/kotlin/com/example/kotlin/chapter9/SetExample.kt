package com.example.kotlin.chapter9

fun main() {
    val anySet = setOf<Any>(123, "123", Any())

    println(anySet.contains(123))
    println(anySet.contains("123"))
}
