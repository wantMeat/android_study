package com.zzzyyymmm.custom

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zzzyyymmm.study.R

/**
 * @author  zym
 * @date  2022/6/14 11:52
 */
class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val newsTitleItem: TextView = view.findViewById(R.id.newsTitleItem)
}