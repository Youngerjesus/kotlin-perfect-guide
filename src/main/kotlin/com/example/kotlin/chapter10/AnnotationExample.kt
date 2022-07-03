package com.example.kotlin.chapter10

import kotlin.reflect.KClass

annotation class Dependency(vararg val componentClass: KClass<*>)

annotation class Component(
    val name: String = "core",
    val dependency: Dependency = Dependency()
)

@Component("I/O")
class IO

@Component("Log", Dependency(IO::class))
class Logger

@Component(dependency = Dependency(IO::class, Logger::class))
class Main

fun main() {
    val component = Main::class.annotations
        .filterIsInstance<Component>()
        .firstOrNull() ?: return

    println(component.name)
    println(component.dependency.componentClass.joinToString { it.simpleName ?: "" })
}
