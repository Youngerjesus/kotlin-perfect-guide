package com.example.kotlin.chapter4

class Person (val firstName: String, val familyName: String) {
    val fullName: String
        get() {
            return "$firstName $familyName"
        }
}

fun main () {
    val person = Person("john", "doe")
    println(person.fullName)
}