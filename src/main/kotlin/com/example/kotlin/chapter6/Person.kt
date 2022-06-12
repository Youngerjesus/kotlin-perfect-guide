package com.example.kotlin.chapter6

data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int
)

fun main() {
    val person = Person("steven", "lorgeous", 20)
    val person2 = Person("steven", "lorgeous", 20)
    val personArray = arrayOf(person, person2)

    for ((firstName, lastName, age) in personArray) {
        println("$firstName $lastName $age")
    }
}
