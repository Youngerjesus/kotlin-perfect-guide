package com.example.kotlin.chapter5

class Address3 {
    var city: String = ""
    var street: String = ""
    var house: String = ""
}

fun main() {
    Address3().apply {
        city = "London"
        street = "Baker Street"
        house = "221b"
    }
}
