package com.example.kotlin.chapter9

interface List<out T> {
    val size: Int

    fun get(index: Int): T
}

interface MutableList<T> : List<T> {
    fun set(index: Int, value: T)
}

class ListByArray<T>(vararg val items: T) : List<T> {
    override val size: Int
        get() = items.size

    override fun get(index: Int): T {
        return items[index]
    }
}

fun <T> concat(list1: List<T>, list2: List<T>) = object : List<T> {
    override val size: Int
        get() = list1.size + list2.size

    override fun get(index: Int): T {
        return if (index < list1.size) {
            return list1.get(index)
        } else {
            list2.get(index - list1.size)
        }
    }
}

fun main() {
    val numbers = ListByArray<Number>(1, 2.0f, 2.5)
    val integers = ListByArray<Int>(1, 2, 3)
    val result = concat(numbers, integers)
}
