package com.rebwon.kotlinstudy.basics.step1

import java.util.Objects
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Children(
    @Id
    val id: String,
    val name: String
) {

    val honorific = name + "님"

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val children = o as Children
        return id == children.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}
