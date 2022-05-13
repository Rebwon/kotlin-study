package com.rebwon.kotlinstudy.basics.step5

fun main() {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    val names = people.joinToString(separator = " ") { p -> p.name }
    println(names)

    val getAge = { p: Person -> p.age }
    val max = people.maxOf(getAge)

    val sumOf = { x: Int, y: Int ->
        println("sumOf($x, $y)")
        x + y
    }
    println(sumOf(1, 2))
}

data class Person(val name: String, val age: Int)

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}
