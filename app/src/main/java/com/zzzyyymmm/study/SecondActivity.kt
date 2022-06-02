package com.zzzyyymmm.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    private val tag = "SecondActivity"
    private val lifecycleFlag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag, this.toString())
        Log.e(tag, "task id is $taskId")

        setContentView(R.layout.activity_second)
        val stringExtra = intent.getStringExtra("title")
        Toast.makeText(this, stringExtra, Toast.LENGTH_SHORT).show()
        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("secondMsg", "secondMsg run")
            startActivity(intent)
/*            setResult(RESULT_OK, intent)
            finish()*/
        }

        val thirdBtn = findViewById<Button>(R.id.thirdBtn)
        thirdBtn.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()
        if (lifecycleFlag) Log.e(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        if (lifecycleFlag) Log.e(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        if (lifecycleFlag) Log.e(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        if (lifecycleFlag) Log.e(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (lifecycleFlag) Log.e(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        if (lifecycleFlag) Log.e(tag, "onRestart")
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("secondMsg", "backMsg run")
        setResult(RESULT_OK, intent)
        finish()
    }
}