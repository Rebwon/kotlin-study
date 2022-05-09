package com.rebwon.kotlinstudy.kotest

import io.kotest.core.spec.BeforeTest
import io.kotest.core.spec.style.*
import io.kotest.matchers.shouldBe

class FunSpecsTest : FunSpec({
    test("String length should return the length of the string")
    {
        "sammy".length shouldBe 5
        "".length shouldBe 0
    }
    context("this outer block is enabled") {
        xtest("this test is disabled") {
            // test here
        }
        test("this test is enabled") {
            println("enabled test!")
        }
    }
    xcontext("this block is disabled") {
        test("disabled by inheritance from the parent") {
            // test here
        }
    }
})

// Parameterized test와 유사.
class DynamicSpecsTest : FunSpec({
    listOf(
        "sam",
        "pam",
        "tim"
    ).forEach {
        test("$it should be a three letter name"){
            it.length shouldBe 3
        }
    }
})

val resetDatabase: BeforeTest = {
    // truncate all db tables here
}

class ReusableCallbacks : FunSpec({

    beforeTest(resetDatabase)

    test("this test will have a sparkling clean database!") {
        // test logic here
    }
})

class StringSpecsTest : StringSpec({
    "Hello, World!" {
        "Hello, World!" shouldBe "Hello, World!"
    }
    "strings.length should return size of string enabled false".config(enabled = false, invocations = 3) {
        "hello".length shouldBe 5
    }
    "strings.length should return size of string enabled true".config(enabled = true, invocations = 3) {
        "hello".length shouldBe 5
    }
})

class GivenWhenThenSpecsTest : BehaviorSpec({
    Given("a string") {
        val str = "sammy"
        When("I call length") {
            val length = str.length
            Then("it should return the length of the string") {
                length shouldBe 5
            }
        }
    }
})

class WordSpecsTest : WordSpec({
    "Hello" When {
        "asked for length" should {
            "return 5" {
                "Hello".length shouldBe 5
            }
        }
        "appended to Bob" should {
            "return Hello Bob" {
                "Hello " + "Bob" shouldBe "Hello Bob"
            }
        }
    }
})

class FeatureSpecsTest : FeatureSpec({
    feature("the can of coke") {
        scenario("should be fizzy when I shake it") {
            // test here
        }
        scenario("and should be tasty") {
            // test here
        }
    }
    feature("this outer block is enabled") {
        xscenario("this test is disabled") {
            // test here
        }
    }
    xfeature("this block is disabled") {
        scenario("disabled by inheritance from the parent") {
            // test here
        }
    }
})

class AnnotationSpecExample : AnnotationSpec() {

    @BeforeEach
    fun beforeTest() {
        println("Before each test")
    }

    @Test
    @Ignore
    fun test1() {
        1 shouldBe 1
    }

    @Test
    fun test2() {
        3 shouldBe 3
    }
}
