package com.zzzyyymmm.demo

import kotlin.math.max


fun main() {
    println(largerNum(2, 3))
    println(checkInput(2L))
    //forFun()
    val person = Person("zym", "28")
    println(person.eat())
    val student = Student("123", "223", "323", "423")
    println(student.toStr())
    study(student)

    val stu2 = Student("name2","age2")
    println(stu2.toStr())

    val cellphone = Cellphone("xm", 1899.0)
    println(cellphone)
    Singleton.printMsg()
}


fun largerNum(num1: Int, num2: Int) = max(num1, num2)

fun checkInput(inp: Number) = when (inp) {
    is Int -> "type Int"
    is Double -> "type Double"
    else -> "other"
}

fun forFun() {
    for (i in 1 until 10) {
        println(i)
    }
}

fun study(stu: Study) {
    stu.readBooks()
    stu.doHomeWork()
}
