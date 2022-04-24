package com.zzzyyymmm.demo

class Student(
    private val sno: String,
    private val grade: String,
    private val name: String,
    private val age: String
) :
    Person(name, age), Study {
    fun toStr() {
        println("sno:%s,grade:%s,name:%s,age:%s".format(sno, grade, name, age))
    }

    override fun readBooks() {
        println("%s read books".format(name))
    }

    override fun doHomeWork() {
        println("%s do homework".format(name))
    }
}