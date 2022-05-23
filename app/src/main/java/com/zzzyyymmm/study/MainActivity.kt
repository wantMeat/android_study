package com.zzzyyymmm.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("开始了", "这是啥")
        setContentView(R.layout.activity_main)
        Log.e("结束了", "报错了")

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            Toast.makeText(this, "点击了按钮", Toast.LENGTH_SHORT).show()
        }

    }
}