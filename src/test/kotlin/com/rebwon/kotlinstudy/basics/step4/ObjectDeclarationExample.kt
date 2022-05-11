package com.rebwon.kotlinstudy.basics.step4

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
    }
}

data class Person(val name: String, val age: Int) {

    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

object CaseInsensitiveComparator : Comparator<File> {

    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

class A {

    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

interface JsonFactory<T> {
    fun fromJson(json: String): T
}

class Person1(val name: String) {
    companion object : JsonFactory<Person1> {
        override fun fromJson(json: String): Person1 {
            return Person1(json)
        }
    }
}

fun main() {
    // CaseInsensitiveComparator.compare(File("/User"), File("/user"))

    val list = listOf(File("/User"), File("/A"))
    println(list.sortedWith(CaseInsensitiveComparator))

    val persons = listOf(Person("Alice", 29), Person("Bob", 31))
    println(persons.sortedWith(Person.NameComparator))

    A.bar()

    val listener = object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            println("Mouse clicked")
        }
    }
}

fun countClicks(window: Window) {
    var clickCount = 0
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }
    })
}
