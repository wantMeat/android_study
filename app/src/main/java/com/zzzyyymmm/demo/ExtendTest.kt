package com.zzzyyymmm.demo

import com.zzzyyymmm.demo.StringExtend.letterCount


fun main() {
    println("aB1212C".letterCount())
    //测试加减乘除语法糖
    val money = Money(20)
    val money2 = Money(40)
    println((money + money2).num)
    println((money + 21).num)
}
