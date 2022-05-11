package com.rebwon.kotlinstudy.basics.step4

class CountingSet<T>(
    private val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet {
    var count = 0

    override fun add(element: T): Boolean {
        count++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        count += elements.size
        return innerSet.addAll(elements)
    }
}

fun main() {
    val set = CountingSet<String>()
    set.add("Hello")
    set.addAll(listOf("World", "!"))
    println("${set.count} objects were added, ${set.size} remain")
}
