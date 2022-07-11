package com.zzzyyymmm.custom

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.zzzyyymmm.entity.News
import com.zzzyyymmm.study.NewsContentActivity
import com.zzzyyymmm.study.R

class NewsAdapter(
    private val newsList: List<News>,
    private val twoPageFlag: Boolean,
    private val activity: FragmentActivity?
) :
    RecyclerView.Adapter<NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        println(newsList)
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        val holder = NewsViewHolder(view)
        holder.newsTitleItem.setOnClickListener {
            val adapterPosition = holder.bindingAdapterPosition
            val news = newsList[adapterPosition]
            if (twoPageFlag) {
                // 如果是双页模式，则刷新NewsContentFragment中的内容
                val newsContentFrag =
                    activity?.supportFragmentManager?.findFragmentById(R.id.newsContentFrag)
                val fragment = newsContentFrag as NewsContentFragment
                fragment.refresh(news.title, news.content)
            } else {
                //切换到新闻内容
                NewsContentActivity.actionStart(
                    parent.context, news.title,
                    news.content
                )
            }
        }

        return holder

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.newsTitleItem.text = news.title
    }

    override fun getItemCount() = newsList.size
}