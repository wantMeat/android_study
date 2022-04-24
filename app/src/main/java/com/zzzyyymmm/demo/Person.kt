package com.zzzyyymmm.demo

open class Person(private val name: String, private val age: String) {
    fun eat() {
        println("%s在吃饭,他今年%s".format(name, age))
    }
}