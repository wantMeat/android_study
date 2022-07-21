package com.zzzyyymmm.study.no8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.zzzyyymmm.ToastUtil
import com.zzzyyymmm.study.R
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class FileSaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_save)

        val fileSaveBtn = findViewById<Button>(R.id.fileSaveBtn)
        fileSaveBtn.setOnClickListener {
            val fileSaveEdit = findViewById<EditText>(R.id.fileSaveEdit)
            val openFileOutput = openFileOutput("test_save", Context.MODE_PRIVATE)
            val bufferedWriter = BufferedWriter(OutputStreamWriter(openFileOutput))
            bufferedWriter.use {
                it.write(fileSaveEdit.text.toString())
            }
        }

        ToastUtil.shortToast(this, "开始回写数据")
        val readSaveFileStr = readSaveFile()
        if (readSaveFileStr.isNotBlank()) {
            val fileSaveEdit = findViewById<EditText>(R.id.fileSaveEdit)
            fileSaveEdit.apply {
                setText(readSaveFileStr)
                setSelection(readSaveFileStr.length / 2)
            }
        }

        val preferencesSaveBtn = findViewById<Button>(R.id.preferencesSaveBtn)
        preferencesSaveBtn.setOnClickListener {
            ToastUtil.shortToast(this, "preferences save success")
            getSharedPreferences("preferencesSave", Context.MODE_PRIVATE).edit().apply {
                putString("saveFirst", "test1");
                putBoolean("saveBool", false);
                putFloat("saveFloat", 2.01F);
                apply();
            }
        }

        val preferencesReadBtn = findViewById<Button>(R.id.preferencesReadBtn)
        preferencesReadBtn.setOnClickListener {
            getSharedPreferences("preferencesSave", Context.MODE_PRIVATE).let {
                ToastUtil.shortToast(this, it.getBoolean("saveBool", true).toString())
                ToastUtil.shortToast(this, it.getFloat("saveFloat", 0.0F).toString())
                ToastUtil.shortToast(this, it.getString("saveFirst", "nullVal").toString())
                ToastUtil.shortToast(this, it.getLong("saveLong", 999L).toString())
            }
        }

    }

    private fun readSaveFile(): String {

        val openFileInput = openFileInput("test_save")
        val bufferedReader = BufferedReader(InputStreamReader(openFileInput))
        val stringBuilder = StringBuilder()
        bufferedReader.use {
            bufferedReader.forEachLine {
                stringBuilder.append(it)
            }
        }
        return stringBuilder.toString()
    }


}