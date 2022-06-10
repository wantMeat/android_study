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
import com.zzzyyymmm.study.RecyclerViewActivity

/**
 * @author  zym
 * @date  2022/6/9 11:25
 */
class FruitRecycleAdapter(private val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitRecycleAdapter.FruitViewHolder>() {
    inner class FruitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }

    override fun getItemCount() = fruitList.size
}