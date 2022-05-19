package com.rebwon.kotlinstudy.basics.step6

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
}

fun main() {
    val numbers = listOf(1, 2, null, 3, null, 4, 5)
    addValidNumbers(numbers)

    val strings = listOf("a", "b", "c", "d", "e")
    val target = mutableListOf<String>()
    copyElements(strings, target)

    println("Copied elements: $target")
}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}
