package com.zzzyyymmm.custom

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import com.zzzyyymmm.ToastUtil
import com.zzzyyymmm.study.R

class TitleLayout(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.activity_title_bar, this)
        val backBarBtn = findViewById<Button>(R.id.backBarBtn)
        val editBarBtn = findViewById<Button>(R.id.editBarBtn)

        backBarBtn.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }

        editBarBtn.setOnClickListener {
            ToastUtil.shortToast(context, "edit show")
        }
    }

}