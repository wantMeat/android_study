package com.zzzyyymmm.collectionDemo

import com.zzzyyymmm.demo.*
import java.util.*
import kotlin.math.max


fun main() {
    //快捷创建list(不可变)
    val listOf = listOf<String>("cs1", "cs2", "cs3", "cs4")
    for (str in listOf) {
        println(str)
    }
    //快捷创建list(可变)
    val mutableListOf = mutableListOf("apple123", "apple23", "apple3")
    mutableListOf.add("apple4")
    for (mu in mutableListOf) {
        println(mu)
    }
    //快捷创建map(可变)
    val mutableMapOf = mutableMapOf("1" to "one", 2 to "two", 3 to "three")
    for (item in mutableMapOf) {
        println(item)
    }

    for ((key, value) in mutableMapOf) {
        println("key is %s ,value is %s".format(key, value))
    }
    //list lambda
    val maxByOrNull = mutableListOf.maxByOrNull { it.length }
    println(maxByOrNull)
    val map = mutableListOf.map { it.uppercase(Locale.getDefault()) }
    for (res in map) {
        println(res)
    }

    val filterMap = mutableListOf.filter { it.contains("2") }.map { it.uppercase() }
    val any = mutableListOf.any { it.contains("123") }
    val all = mutableListOf.all { it.contains("123") }
    println(filterMap)
    println(any)
    println(all)


}