package com.example.kotlin.chapter11

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

var text: String by Delegates.notNull()

class Test {
    lateinit var test: String
    var testInt: Int by Delegates.notNull()
}

class Person(name: String, val age: Int) {
    var name: String by Delegates.observable(name) { _, old, new ->
        println("Name changed: $old to $new")
    }

}

class Test2(name: String) : ObservableProperty<String>(name) {
    override fun afterChange(property: KProperty<*>, oldValue: String, newValue: String) {
        super.afterChange(property, oldValue, newValue)
    }

    override fun beforeChange(property: KProperty<*>, oldValue: String, newValue: String): Boolean {
        return super.beforeChange(property, oldValue, newValue)
    }
}

class CarItem(data: Map<String, Any?>) {
    val title: String by data
    val price: Double by data
    val quantity: Int by data
}

fun main() {
    val person = Person("John", 25)
    person.name = "harry"

    val carItem = CarItem(
        mapOf(
            "title" to "latop",
            "price" to 999.9,
            "quantity" to 5
        )
    )

    println(carItem.title)
}
