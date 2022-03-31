package com.example.kotlin.chapter4

import java.io.File

class Lazy {
    val text by lazy { File("data.txt").readText() }
}

fun main() {
    val lazy = Lazy()
    println(lazy.text)
}