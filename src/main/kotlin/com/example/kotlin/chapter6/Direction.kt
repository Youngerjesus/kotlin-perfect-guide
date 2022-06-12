package com.example.kotlin.chapter6

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun main() {
    println(Direction.WEST.name)
    println(Direction.WEST.ordinal)

    println(Direction.valueOf("NORTH"))

    println(Direction.values())
}
