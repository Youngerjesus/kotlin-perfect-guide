package com.example.kotlin.chapter5

class Address {
    var zipCode: Int = 0
    var city: String = ""
    var street: String = ""
    var house: String = ""

    fun post(message: String): Boolean {
        "Message for ($zipCode, $city, $street, $house): $message"
        return readLine() == "OK"
    }
}

class Address2(val city: String, val street: String, val houst: String) {
    fun asText() = "$city, $street, $houst"
}

fun main() {
    val address2 = run {
        val city = readLine() ?: return
        val street = readLine() ?: return
        val house = readLine() ?: return
        Address2(city, street, house)
    }

    val isReceived = Address().run {
        zipCode = 12345
        city = "London"
        street = "Baker Steet"
        house = "221b"
        post("hello")
    }
}
