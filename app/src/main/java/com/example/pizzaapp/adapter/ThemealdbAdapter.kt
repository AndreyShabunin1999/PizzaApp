package com.example.pizzaapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.model.responce.ThemealdbResponce
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso


class ThemealdbAdapter(private var mList: ThemealdbResponce) : RecyclerView.Adapter<ThemealdbAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: MaterialTextView = itemView.findViewById(R.id.product_name)
        val description: MaterialTextView = itemView.findViewById(R.id.product_description)
        val img_prod: ImageView = itemView.findViewById(R.id.image_eat)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = mList.meals?.get(position)?.strMeal ?: ""
        holder.description.text = mList.meals?.get(position)?.idMeal ?: ""
        val text_url: String = mList.meals?.get(position)?.strMealThumb ?: ""

        Picasso.with(holder.itemView.context).load(text_url).into(holder.img_prod)
    }

    override fun getItemCount(): Int {
        return mList.meals?.size ?: 0
    }

}