package com.rebwon.kotlinstudy.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec

// f: 키워드는 top level test에만 적용 가능.
class FocusExample : FunSpec({
    context("test 1") {
        // this will be skipped
        test("foo") {
            // this will be skipped
        }
    }

    context("f:test 2") {
        // this will be executed
        test("foo") {
            // this will be executed
        }
    }

    context("test 3") {
        // this will be skipped
        test("foo") {
            // this will be skipped
        }
    }
})

class BangExample : StringSpec({

    "!test 1" {
        // this will be ignored
    }

    "test 2" {
        // this will run
    }

    "test 3" {
        // this will run too
    }
})
