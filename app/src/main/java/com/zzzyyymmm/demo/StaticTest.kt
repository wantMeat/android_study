package com.zzzyyymmm.demo

import android.util.Log

/**
 * @author  zym
 * @date  2022/6/7 13:18
 */
class StaticTest {
    companion object {
        @JvmStatic
        fun staticFun() = println("staticFun run")
    }
}