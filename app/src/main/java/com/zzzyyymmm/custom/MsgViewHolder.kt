package com.zzzyyymmm.custom

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zzzyyymmm.study.R

/**
 * @author  zym
 * @date  2022/6/14 11:52
 */
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    class LeftMsgViewHolder(view: View) : MsgViewHolder(view) {
        val uiLeftText: TextView = view.findViewById(R.id.uiLeftText)
    }

    class RightMsgViewHolder(view: View) : MsgViewHolder(view) {
        val uiRightText: TextView = view.findViewById(R.id.uiRightText)
    }

    class RightMsgViewHolder2(view: View) : MsgViewHolder(view) {
        val uiRightText: TextView = view.findViewById(R.id.uiRightText)
    }
}