package com.rebwon.kotlinstudy

import com.rebwon.kotlinstudy.messaging.MessageAdapter
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinStudyApplicationTests {

    @Test
    fun contextLoads(@Autowired messageAdapter: MessageAdapter) {
        messageAdapter.adaptive()
    }
}
