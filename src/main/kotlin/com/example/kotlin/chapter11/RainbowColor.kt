package com.example.kotlin.chapter11

enum class RainbowColor {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    operator fun inc() = values[(ordinal + 1) % values.size]

    operator fun dec() = values[(ordinal - 1) % values.size]

    companion object {
        private val values = enumValues<RainbowColor>()
    }
}
