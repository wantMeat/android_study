package com.zzzyyymmm.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.zzzyyymmm.ToastUtil

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ToastUtil.shortToast(context, "BootCompleteReceiver run")
        abortBroadcast()
        ToastUtil.shortToast(context, "有序广播中断")
    }
}