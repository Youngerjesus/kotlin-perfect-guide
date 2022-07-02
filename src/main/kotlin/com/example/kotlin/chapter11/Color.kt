package com.example.kotlin.chapter11

enum class Color {
    BLACK, RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE;

    operator fun not() = when (this) {
        BLACK -> WHITE
        RED -> CYAN
        GREEN -> MAGENTA
        BLUE -> YELLOW
        WHITE -> BLACK
        CYAN -> RED
        MAGENTA -> GREEN
        YELLOW -> BLUE
    }
}
