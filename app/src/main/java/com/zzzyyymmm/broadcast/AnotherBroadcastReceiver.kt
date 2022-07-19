package com.zzzyyymmm.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.zzzyyymmm.ToastUtil

class AnotherBroadcastReceiver :BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ToastUtil.longToast(context, "AnotherBroadcastReceiver run")
    }
}