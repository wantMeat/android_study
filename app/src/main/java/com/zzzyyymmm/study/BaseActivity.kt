package com.zzzyyymmm.study

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.zzzyyymmm.ToastUtil

/**
 * @author  zym
 * @date  2022/6/6 11:47
 */
open class BaseActivity : AppCompatActivity() {

    lateinit var offlineBroadcastReceiver: OfflineBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
        Log.d("BaseActivity", javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        //创建
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.zzzyyymmm.study.FORCE_OFFLINE")
        offlineBroadcastReceiver = OfflineBroadcastReceiver()
        registerReceiver(offlineBroadcastReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        //暂停
        unregisterReceiver(offlineBroadcastReceiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class OfflineBroadcastReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("警告")
                setMessage("你退出了系统,将跳转到登录界面进行重新登录")
                setCancelable(false)
                setPositiveButton("OK") { _, _ ->
                    ActivityCollector.finishAll()
                    //val newIntent = Intent(context, LoginActivity::class.java)
                    //startActivity(newIntent)
                }
                show()
            }
        }
    }
}