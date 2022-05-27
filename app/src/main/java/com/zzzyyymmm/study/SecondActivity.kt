package com.zzzyyymmm.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val stringExtra = intent.getStringExtra("title")
        Toast.makeText(this, stringExtra, Toast.LENGTH_SHORT).show()
        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("secondMsg", "secondMsg run")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("secondMsg", "backMsg run")
        setResult(RESULT_OK,intent)
        finish()
    }
}