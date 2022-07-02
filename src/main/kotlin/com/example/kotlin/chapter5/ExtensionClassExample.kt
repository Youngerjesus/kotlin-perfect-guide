package com.example.kotlin.chapter5

class Address4(val city: String, val street: String, val house: String)

class Person(val firstName: String, val familyName: String) {
    fun Address4.post(message: String) {

        // 암시적 this: 확장 수신 객체 (Address4)
        val city = city

        // 한정시키지 않은 this: 확장 수신 객체 (Address4)
        val street = this.city

        // 한정시킨 this: 확장 수신 객체 (Address4)
        val house = this@post.house

        // 암시적 this: 디스패치 수신객체 (Person)
        val firstName = firstName

        // 한정시킨 this: 디스패치 수신 객체 (Person)
        val familyName = this@Person.familyName
    }
}
