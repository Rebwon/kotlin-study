package com.rebwon.kotlinstudy.basics.step7

fun main() {
    val (name, extension) = splitFilename("example.kt")
    println("name: $name, extension: $extension")

    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}

data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}
