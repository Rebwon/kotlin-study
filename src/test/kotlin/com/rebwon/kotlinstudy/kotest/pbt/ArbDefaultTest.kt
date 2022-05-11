package com.rebwon.kotlinstudy.kotest.pbt

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.throwable.shouldHaveMessage
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.property.Arb
import io.kotest.property.arbitrary.default
import io.kotest.property.checkAll

class ArbDefaultTest : WordSpec({

    "Gen.default" should {
        "generate defaults for list" {

            val gen = Arb.default<List<Int>>()
            checkAll(10, gen) { list ->
                list.forAll { i ->
                    i.shouldBeInstanceOf<Int>()
                }
            }
        }

        "generate defaults for set" {
            val gen = Arb.default<Set<String>>()
            checkAll(10, gen) { set ->
                set.forAll { s ->
                    s.shouldBeInstanceOf<String>()
                }
            }
        }

        "support basic data classes" {
            checkAll<Foo> { it.shouldNotBeNull() }
        }

        "throw on complex data class" {
            shouldThrow<IllegalStateException> {
                checkAll<Bar> { it.shouldNotBeNull() }
            }.shouldHaveMessage("Could not locate generator for parameter com.rebwon.kotlinstudy.kotest.pbt.Bar.t")
        }
    }
})

data class Foo(val a: Int, val b: String)

data class Bar(val s: String, val t: Thread)
