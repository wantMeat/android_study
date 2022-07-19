package com.zzzyyymmm.demo

object StringExtend {
    fun String.letterCount(): Int {
        var count = 0
        for (char in this) {
            if (char.isLetter())
                count++
        }
        return count
    }

    operator fun String.times(n: Int) = repeat(n)
}