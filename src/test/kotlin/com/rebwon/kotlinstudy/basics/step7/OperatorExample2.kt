package com.rebwon.kotlinstudy.basics.step7

import java.time.LocalDate

fun main() {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2)
    println("abc" < "bac")

    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)

    val newYear = LocalDate.ofYearDay(2020, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (day in daysOff) {
        println(day)
    }
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start

        override fun hasNext() =
            current <= endInclusive

        override fun next() = current.apply {
            current = plusDays(1)
        }
    }

class Person(
    val firstName: String,
    val lastName: String
) : Comparable<Person> {

    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}
