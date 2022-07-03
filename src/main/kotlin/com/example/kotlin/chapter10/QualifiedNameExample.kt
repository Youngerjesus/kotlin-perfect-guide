package com.example.kotlin.chapter10

class QualifiedNameExample {
    inner class Test {

    }
}

class QualifiedClass2

fun main() {
    println(QualifiedNameExample.Test::class.qualifiedName)
    println(QualifiedClass2::class.qualifiedName)
}
