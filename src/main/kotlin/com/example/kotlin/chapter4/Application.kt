package com.example.kotlin.chapter4

class Application private constructor(){

    object Factory {
        fun create(): Application {
            return Application()
        }
    }

    companion object {
        fun create2(): Application {
            return Application()
        }
    }
}

fun main() {
    val create2 = Application.create2()
    val create = Application.Factory.create()
}