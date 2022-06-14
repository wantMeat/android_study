package com.zzzyyymmm.custom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zzzyyymmm.entity.Msg
import com.zzzyyymmm.study.R

class MsgAdapter(private val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return msgList[position].type

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        val view: View
        if (viewType == Msg.TYPE_RECEIVED) {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            return MsgViewHolder.LeftMsgViewHolder(view)
        } else {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
            return MsgViewHolder.RightMsgViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is MsgViewHolder.LeftMsgViewHolder -> holder.uiLeftText.text = msg.content
            is MsgViewHolder.RightMsgViewHolder -> holder.uiRightText.text = msg.content
        }
    }

    override fun getItemCount() = msgList.size
}