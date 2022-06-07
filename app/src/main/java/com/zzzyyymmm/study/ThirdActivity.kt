package com.zzzyyymmm.study

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThirdActivity : BaseActivity() {

    private val tag = "ThirdActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag, "task id is $taskId")
        setContentView(R.layout.activity_third)



        val finishBtn = findViewById<Button>(R.id.finishBtn)
        finishBtn.setOnClickListener {
            ActivityCollector.finishAll()
        }
    }

    companion object {
        fun actionStart(context: Context, msg: String, data: String) {
            context.startActivity(Intent(context, ThirdActivity::class.java).apply {
                putExtra("msg", msg)
                putExtra("data", msg)
            })
        }
    }
}