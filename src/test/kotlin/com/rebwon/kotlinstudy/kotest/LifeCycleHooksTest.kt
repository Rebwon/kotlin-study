package com.rebwon.kotlinstudy.kotest

import io.kotest.core.spec.style.WordSpec

class TestSpec : WordSpec({
    beforeTest {
        println("Starting a test $it")
    }
    afterTest { (test, result) ->
        println("Finished spec with result $result")
    }
    "this test" should {
        "be alive" {
            println("Johnny5 is alive!")
        }
    }
})
