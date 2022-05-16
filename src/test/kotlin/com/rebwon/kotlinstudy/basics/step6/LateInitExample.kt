package com.rebwon.kotlinstudy.basics.step6

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class LateInitExample : AnnotationSpec() {

    private lateinit var service: MyService

    @BeforeEach
    fun beforeTest() {
        service = MyService()
    }

    @Test
    fun test2() {
        service.performAction() shouldBe "foo"
    }
}

class MyService {
    fun performAction(): String = "foo"
}
