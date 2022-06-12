package com.example.kotlin.chapter6

@JvmInline
value class Dollar(val amount: Int) {
    val isDebt get() = amount < 0
    fun add(d: Dollar) = Dollar(amount + d.amount)
}

fun main() {
    val dollar = Dollar(5)
    println(dollar)
}
