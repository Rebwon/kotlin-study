package com.rebwon.kotlinstudy.basics.step5

fun main() {

    var counter = 0
    val inc = { counter++ }

    val counter1 = Ref(0)
    val inc1 = { counter1.value++ }

    val createPerson = ::Person3
    val person = createPerson("Rebwon", 12)
    println(person)

    val predicate = Person3::isAdult

    val personAgeFunc = Person3::age
    val personAge = personAgeFunc(person)
    println(personAge)

    val dmitrysAgeFunc = person::age
    println(dmitrysAgeFunc)
}

class Ref<T>(var value: T)

data class Person3(val name: String, val age: Int)

fun Person3.isAdult() = age >= 20
