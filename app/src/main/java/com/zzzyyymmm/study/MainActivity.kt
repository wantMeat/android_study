package com.zzzyyymmm.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("开始了", "这是啥")
        setContentView(R.layout.activity_main)
        Log.e("结束了", "报错了")

    }
}