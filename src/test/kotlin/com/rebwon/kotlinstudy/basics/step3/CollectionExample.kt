package com.rebwon.kotlinstudy.basics.step3

private const val MAX_NUMBER2 = 100
const val MAX_NUMBER = 100
var opCount = 0

fun performOperation() {
    opCount++
}

fun printOpCount() {
    println("Operation performed $opCount times")
}

fun main() {
    val strings = listOf("first", "second", "third")
    println(strings.last())

    val numbers = setOf(1, 2, 3)
    println(numbers.maxOf { it })

    val list = listOf(1, 2, 3)
    println(joinToString(list, separator = "; ", prefix = "(", postfix = ")"))

    val list2 = listOf(1, 2, 3)
    println(joinToString(list2))
}

@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
