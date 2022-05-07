package com.rebwon.kotlinstudy.basics.step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    internal fun namedParameter() {
        val persons = listOf(
            Person("키미태", 29, "킴희태"),
            Person("키미태", 20, nickname = "킴희태"),
            Person(name = "키미태", age = 20, nickname = "킴희태")
        )

        assertThat(persons[0].name).isEqualTo("키미태")
        assertThat(persons[1].name).isEqualTo("키미태")
        assertThat(persons[2].name).isEqualTo("키미태")
    }

    @Test
    internal fun nullable() {
        val person = Person("키미태", 29, null)

        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun defaultArguments() {
        val person = Person("키미태", 29)

        assertThat(person.name).isEqualTo(person.nickname)
        assertThat(person.nickname).isNotNull
    }

    @Test
    internal fun dataClass() {
        val person1 = Person("키미태", 29)
        val person2 = Person("키미태", 29)

        assertThat(person1).isEqualTo(person2)
    }
}
