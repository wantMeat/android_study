package com.zzzyyymmm.study

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class ViewActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        val showTextBtn = findViewById<Button>(R.id.showTextBtn)
        showTextBtn.setOnClickListener(this)
        //图片
        val imgView = findViewById<ImageView>(R.id.imgView)
        imgView.setOnClickListener {
            imgView.setImageResource(R.drawable.img_2)
        }

        //加载条
        val loadingBtn = findViewById<Button>(R.id.loadingBtn)
        val loadingBar = findViewById<ProgressBar>(R.id.loadingBar)
        loadingBtn.setOnClickListener {
            if (loadingBar.visibility == View.VISIBLE) {
                loadingBar.visibility = View.GONE
            } else {
                loadingBar.visibility = View.VISIBLE
                loadingBar.max += 10
            }
        }

        //弹窗
        val dialogBtn = findViewById<Button>(R.id.dialogBtn)
        dialogBtn.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("dialog title")
                setMessage("这是一个弹窗")
                setCancelable(false)
                setPositiveButton("OK") { dialog, which -> {} }
                setNegativeButton("Cancel") { dialog, which -> {} }
                show()
            }
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.showTextBtn -> {
                val editText = findViewById<EditText>(R.id.editText)
                val textStr = editText.text.toString()
                Toast.makeText(this, textStr, Toast.LENGTH_SHORT).show()
            }
        }
    }
}