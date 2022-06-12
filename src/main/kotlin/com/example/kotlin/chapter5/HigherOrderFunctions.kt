package com.example.kotlin.chapter5

class HigherOrderFunctions {
}

fun aggregate(numbers: IntArray, op: (Int, Int) -> Int): Int {
    var result = numbers.firstOrNull() ?: throw throw IllegalArgumentException("Empty Array")

    for (i in 1..numbers.lastIndex) result = op(result, numbers[i])

    return result
}

fun sum(numbers: IntArray): Int =
    aggregate(numbers) { result, op -> result + op }

fun max(numbers: IntArray): Int =
    aggregate(numbers) {result, op -> if (op > result) op else result}

fun main() {
    println(sum(intArrayOf(1, 2, 3, 4)))
    println(intArrayOf(1, 2, 3, 4))
}

