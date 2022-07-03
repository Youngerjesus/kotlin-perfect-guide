package com.example.kotlin.chapter11

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.isAccessible

class CachedProperty<in R, out T: Any>(val initializer: R.() -> T) {
    private val cachedValues = HashMap<R, T>()

    operator fun getValue(receiver: R, property: KProperty<*>): T {
        return cachedValues.getOrPut(receiver) { receiver.initializer() }
    }
}

class CachedReadOnlyProperty<R, T: Any>(val initializer: R.() -> T) : ReadOnlyProperty<R, T> {
    private val cachedValues = HashMap<R, T>()

    override fun getValue(thisRef: R, property: KProperty<*>): T {
        return cachedValues.getOrPut(thisRef) { thisRef.initializer() }
    }
}


fun <R, T: Any> cached(initializer: R.() -> T) = CachedProperty(initializer)

class Person2(val firstName: String, val familyName: String) {
    val fullName2: String by CachedReadOnlyProperty { "$firstName $familyName" }
}

val Person2.fullName: String by CachedProperty { if (this != null) "$firstName $familyName" else ""}

class Person3(val firstName: String, val familyName: String) {
    val fullName: String by lazy { "$firstName $familyName" }
}

fun main() {
    val johnDoe = Person2("johh", "Doe")

    println(johnDoe.fullName)
    println(johnDoe.fullName2)

    println(johnDoe.fullName)
    println(johnDoe.fullName2)

    val person3 = Person3("john", "doe")

    person3::fullName
        .apply { isAccessible = true }
        .getDelegate()!!::class.qualifiedName
}
