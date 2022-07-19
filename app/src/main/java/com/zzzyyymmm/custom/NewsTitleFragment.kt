package com.zzzyyymmm.custom

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zzzyyymmm.demo.StringExtend.times
import com.zzzyyymmm.entity.News
import com.zzzyyymmm.study.R

class NewsTitleFragment : Fragment() {
    private var isTwoPane = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_CREATE) {
                    isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
                    val layoutManager = LinearLayoutManager(activity)
                    val newsTitleRecyclerView =
                        activity?.findViewById<RecyclerView>(R.id.newsTitleRecyclerView)
                    newsTitleRecyclerView?.layoutManager = layoutManager
                    val adapter = NewsAdapter(getNews(), isTwoPane, activity)
                    newsTitleRecyclerView?.adapter = adapter
                }

            }
        }
        )
    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1..50) {
            val news =
                News("This is news title $i", getRandomLengthString("This is news content $i. "))
            newsList.add(news)
        }
        return newsList
    }

    private fun getRandomLengthString(str: String) = str * (1..20).random()
}