package com.rebwon.kotlinstudy.basics.step7

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person1(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newAge) {
            val oldValue = field
            field = newAge
            changeSupport.firePropertyChange("age", oldValue, newAge)
        }

    var salary: Int = salary
        set(newSalary) {
            val oldValue = field
            field = newSalary
            changeSupport.firePropertyChange("salary", oldValue, newSalary)
        }
}
