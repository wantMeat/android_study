package com.zzzyyymmm

import android.content.Context
import android.widget.Toast

/**
 * @author  zym
 * @date  2022/6/8 12:45
 */
object ToastUtil {
    fun longToast(context: Context, text: CharSequence) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    fun shortToast(context: Context, text: CharSequence) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}