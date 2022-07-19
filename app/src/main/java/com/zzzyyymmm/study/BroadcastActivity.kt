package com.zzzyyymmm.study

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zzzyyymmm.ToastUtil

class BroadcastActivity : AppCompatActivity() {
    lateinit var timeChangeReceiver: TimeChangeReceiver
    val sendAction = "com.zzzyyymmm.study.MY_BROADCAST"
    val otherAction = "com.zzzyyymmm.broadcast.ANOTHER_BROADCAST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)

        //intentFilter.addAction(sendAction)
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)

        val broadcastSendBtn = findViewById<Button>(R.id.broadcastSendBtn)
        broadcastSendBtn.setOnClickListener {
            val intent = Intent(sendAction)
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }

        val broadcastOtherSendBtn = findViewById<Button>(R.id.broadcastOtherSendBtn)
        broadcastOtherSendBtn.setOnClickListener {
            val intent = Intent(sendAction)
            intent.setPackage(packageName)
            sendOrderedBroadcast(intent, null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                Intent.ACTION_TIME_TICK -> ToastUtil.longToast(context, "time value")
                sendAction -> ToastUtil.longToast(context, "send value")
                otherAction -> ToastUtil.longToast(context, "send other value")
                else -> ToastUtil.longToast(context, "other value")
            }

        }

    }
}