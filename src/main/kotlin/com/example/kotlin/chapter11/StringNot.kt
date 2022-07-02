package com.example.kotlin.chapter11

fun isShort(s: String) = s.length <= 4

fun main() {
    val data = listOf("abc", "abcde", "abcd", "abcdef", "ab")

    println(data.count(::isShort))
    println(data.count(!::isShort))
}

operator fun <T> ((T) -> Boolean).not(): (T) -> Boolean = { !this(it)}

