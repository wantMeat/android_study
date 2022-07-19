package com.zzzyyymmm.demo

/**
 * 测试加减乘除重写语法糖
 */
class Money(val num: Int) {
    operator fun plus(money: Money) = Money(this.num + money.num)

    operator fun plus(value: Int) = Money(this.num + value)
}