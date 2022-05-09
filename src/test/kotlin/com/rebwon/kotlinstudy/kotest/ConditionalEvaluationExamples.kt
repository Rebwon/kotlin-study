package com.rebwon.kotlinstudy.kotest

import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.Enabled
import io.kotest.core.test.EnabledIf
import io.kotest.core.test.TestCase

class ConditionalEvaluationExamples : StringSpec({

    val enabledIf: EnabledIf = { !(it.name.testName.startsWith("danger") && isFriday(it)) }

    "danger Will Robinson1".config(enabledIf = enabledIf) {
        // test here
    }

    "safe Will Robinson2".config(enabledIf = enabledIf) {
        // test here
    }

    val enabledOrReasonIf: (TestCase) -> Enabled = {
        if (it.name.testName.startsWith("danger") && isFriday(it))
            Enabled.disabled("It's a friday, and we don't like danger!")
        else
            Enabled.enabled
    }

    "danger Will Robinson3".config(enabledOrReasonIf = enabledOrReasonIf) {
        // test here
    }

    "safe Will Robinson4".config(enabledOrReasonIf = enabledOrReasonIf) {
        // test here
    }
})

private fun isFriday(it: TestCase) = it.name.testName.startsWith("fridays")
