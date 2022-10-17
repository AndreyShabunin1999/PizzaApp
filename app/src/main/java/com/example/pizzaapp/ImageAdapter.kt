package com.example.pizzaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ImageAdapter(private val imageList : ArrayList<Int>, private val viewPager2: ViewPager2)
    : RecyclerView.Adapter<ImageAdapter.imageViewHolder>(){

    class imageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView_adv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): imageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_container, parent, false)
        return imageViewHolder(view)
    }

    override fun onBindViewHolder(holder: imageViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}