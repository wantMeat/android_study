package com.zzzyyymmm.custom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zzzyyymmm.entity.Msg
import com.zzzyyymmm.study.R

class MsgAdapter(private val msgList: List<Msg>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftMsgViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val uiLeftText: TextView = view.findViewById(R.id.uiLeftText)
    }

    inner class RightMsgViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val uiRightText: TextView = view.findViewById(R.id.uiRightText)
    }

    override fun getItemViewType(position: Int): Int {
        return msgList[position].type

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if (viewType == Msg.TYPE_RECEIVED) {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            return LeftMsgViewHolder(view)
        } else {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
            return RightMsgViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftMsgViewHolder -> holder.uiLeftText.text = msg.content
            is RightMsgViewHolder -> holder.uiRightText.text = msg.content
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount() = msgList.size
}