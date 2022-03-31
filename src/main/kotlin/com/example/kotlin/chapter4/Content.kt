package com.example.kotlin.chapter4

import java.io.File

class Content {
    lateinit var text: String

    fun loadFile(file: File) {
        text = file.readText()
    }
}