package com.zzzyyymmm.custom

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zzzyyymmm.entity.Fruit
import com.zzzyyymmm.study.R

/**
 * @author  zym
 * @date  2022/6/9 11:25
 */
class FruitAdapter(activity: Activity, private val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val fruitImage = view.findViewById<ImageView>(R.id.fruitImage)
            val fruitName = view.findViewById<TextView>(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


        // 获取当前项的Fruit实例
        val fruit = getItem(position)
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }

    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)
}