package com.example.kotlin.chapter10

class Person(val firstName: String, val familyName: String)

fun main() {
    val personClass = Person::class
    val person = personClass.constructors.first().call("john", "doe")
    val firstName = personClass.members.first { it.name == "firstName" }

    println(firstName)
}
