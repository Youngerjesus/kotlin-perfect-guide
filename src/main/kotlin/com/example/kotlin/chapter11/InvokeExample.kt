package com.example.kotlin.chapter11

operator fun <K, V> Map<K,V>.invoke(key: K) = get(key)

class Rational(val sign: String, val num: Int, val dem: Int) {
    companion object {
        operator fun invoke(num: Int, den: Int = 1) = Rational("+", num, den)
    }
}

fun main() {
    val map = mapOf("I" to 1, "V" to 5, "X" to 10)

    println(map("I"))

    val rational = Rational(1, 2)
}
