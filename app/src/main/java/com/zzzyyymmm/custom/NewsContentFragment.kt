package com.zzzyyymmm.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.zzzyyymmm.study.NewsContentActivity
import com.zzzyyymmm.study.R

class NewsContentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_content_frag, container, false)
    }

    fun refresh(title: String, content: String) {
        val activity = activity as FragmentActivity
        val contentLayout = view?.findViewById<View>(R.id.contentLayout)
        val newsTitle = activity.findViewById<TextView>(R.id.newsTitle)
        val newsContent = activity.findViewById<TextView>(R.id.newsContent)
        contentLayout?.visibility = View.VISIBLE
        newsTitle.text = title // 刷新新闻的标题
        newsContent.text = content // 刷新新闻的内容
    }
}