package com.zzzyyymmm.collectionDemo


fun main() {

    Thread { println("异步线程执行了") }.start()
    println(checkNull(null, 32))
    println(checkStrLen(null))
}

fun checkNull(num: Int?, defaultNum: Int) = num ?: defaultNum

fun checkStrLen(str: String?) = str?.length ?: 0