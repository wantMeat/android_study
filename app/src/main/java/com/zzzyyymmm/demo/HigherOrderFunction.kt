package com.zzzyyymmm.demo

fun main() {
    println(numFun(100, 20, ::plus))
    println(numFun(100, 20, ::minus))
    println(numFun(100, 20) { a, b -> a * b })
}

fun numFun(num1: Int, num2: Int, innerFun: (Int, Int) -> Int) = innerFun(num1, num2)

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}