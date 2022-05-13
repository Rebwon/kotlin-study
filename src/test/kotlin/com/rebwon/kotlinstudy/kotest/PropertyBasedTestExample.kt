package com.rebwon.kotlinstudy.kotest

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.property.checkAll

class PropertyBasedTestExample : StringSpec({
    "String size" {
        forAll<String, String> { a, b ->
            (a + b).length == a.length + b.length
        }
    }

    "a many iterations test" {
        checkAll<Double, Double>(10_000) { a, b ->
            // test here
        }
    }
})
