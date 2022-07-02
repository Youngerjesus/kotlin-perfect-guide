package com.example.kotlin.chapter11

fun isShort(s: String) = s.length <= 4

fun String.isUppercase() = all { it.isUpperCase() }

fun main() {
    val data = listOf("abc", "abcde", "abcd", "abcdef", "ab")

    println(data.count( ::isShort and String::isUppercase))
}

operator fun <T> ((T) -> Boolean).not(): (T) -> Boolean = { !this(it)}

