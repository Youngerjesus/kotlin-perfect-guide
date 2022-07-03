package com.example.kotlin.chapter11

interface ResultSet<out T> {
    val items: Sequence<T>
}

class From<out T> (private val source: Iterable<T>) : ResultSet<T> {
    override val items: Sequence<T>
        get() = source.asSequence()
}

class Where<out T> (
    private val from: ResultSet<T>,
    private val condition: (T) -> Boolean
) : ResultSet<T> {
    override val items: Sequence<T>
        get() = from.items.filter(condition)
}

class Select<out T, out U> (
    private val from: ResultSet<T>,
    private val output: (T) -> U
) : ResultSet<U> {
    override val items: Sequence<U>
        get() = from.items.map(output)
}

class OrderBy <out T, in K : Comparable<K>> (
    private val select: ResultSet<T>,
    private val orderKey: (T) -> K
) : ResultSet<T> {
    override val items: Sequence<T>
        get() = select.items.sortedBy(orderKey)
}

infix fun <T> From<T>.where (condition: (T) -> Boolean) = Where(this, condition)

infix fun <T, U> From<T>.select (output: (T) -> U) = Select(this, output)

infix fun <T, U> Where<T>.select (output: (T) -> U) = Select(this, output)

infix fun <T, K: Comparable<K>> Select<*, T>.orderBy(
    orderKey: (T) -> K
) = OrderBy(this, orderKey)

fun main() {
    val nums = listOf(2, 8, 1, 9, 3, 6, 5)
    val query = From(nums) where { it > 3 } select { it * 2 } orderBy { it }
}
