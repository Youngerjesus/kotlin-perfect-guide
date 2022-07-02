package com.example.kotlin.chapter11

fun String.contains(s: String) = s[0] == 's'

fun main() {
    val S = "abcdabcd"
    val S2 = "abcd"

    println(S.contains(S2))
}
