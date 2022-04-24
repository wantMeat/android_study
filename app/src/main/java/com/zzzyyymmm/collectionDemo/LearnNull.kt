package com.zzzyyymmm.collectionDemo


fun main() {
    println(checkNull(null, 32))
}

fun checkNull(num: Int?, defaultNum: Int) = num ?: defaultNum