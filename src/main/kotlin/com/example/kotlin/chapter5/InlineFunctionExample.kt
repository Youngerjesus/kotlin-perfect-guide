package com.example.kotlin.chapter5

class InlineFunctionExample {
}

inline fun calculate(param: Int, operation: (Int) -> Boolean): Int {
    return 5
}