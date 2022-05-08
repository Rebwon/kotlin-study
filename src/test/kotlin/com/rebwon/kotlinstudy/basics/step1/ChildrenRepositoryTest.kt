package com.rebwon.kotlinstudy.basics.step1

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.UUID

@DataJpaTest
class ChildrenRepositoryTest {

    @Test
    internal fun create(@Autowired childrenRepository: ChildrenRepository) {
        val children = Children(id = UUID.randomUUID().toString(), name = "윤성우")
        childrenRepository.save(children)

        println(children.honorific)
    }
}
