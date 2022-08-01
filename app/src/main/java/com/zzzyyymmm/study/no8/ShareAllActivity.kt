package com.zzzyyymmm.study.no8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.zzzyyymmm.study.R
import java.io.BufferedWriter
import java.io.OutputStreamWriter

class ShareAllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_all)

        val callRoleBtn = findViewById<Button>(R.id.callRoleBtn)
        callRoleBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_CALL)
                startActivity(intent)
            } catch (e: SecurityException) {
                e.printStackTrace()
            }
        }

    }
}