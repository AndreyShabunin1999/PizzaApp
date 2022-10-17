package com.example.pizzaapp.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.model.responce.ThemealdbResponce
import com.google.android.material.textview.MaterialTextView
import java.util.logging.Logger

class ThemealdbAdapter(private var mList: List<ThemealdbResponce>) : RecyclerView.Adapter<ThemealdbAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: MaterialTextView = itemView.findViewById(R.id.product_name)
        val description: MaterialTextView = itemView.findViewById(R.id.product_description)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = mList[position].strMeal
        holder.description.text = mList[position].strMealThumb
        Log.d(TAG, "LIST: $mList")
    }

    override fun getItemCount(): Int {
        var size: Int = mList.size
        Log.d(TAG, "SIZE: $size")
        return mList.size
    }

}