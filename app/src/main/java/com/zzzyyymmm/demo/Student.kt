package com.zzzyyymmm.demo

class Student(
    private val sno: String,
    private val grade: String,
    private val name: String,
    private val age: String
) :
    Person(name, age), Study {
    constructor(name: String, age: String) : this("", "", name, age)

    fun toStr() {
        println("sno:%s,grade:%s,name:%s,age:%s".format(sno, grade, name, age))
    }

    override fun readBooks() {
        println("${name} read books")
    }

    override fun doHomeWork() {
        println("%s do homework".format(name))
    }

    fun doStudy(study: Study?) {
        study?.let {
            it.readBooks()
            it.doHomeWork()
        }
    }
}