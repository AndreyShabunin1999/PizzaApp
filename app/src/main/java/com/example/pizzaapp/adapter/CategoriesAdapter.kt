package com.example.pizzaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.model.responce.CategoriesResponce

class CategoriesAdapter(private val mListCat: CategoriesResponce, val bar: (input: String) -> Unit) :
        RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private val items: MutableList<CardView>
    private lateinit var context: Context

    init {
        this.items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v: View = LayoutInflater.from(context)
            .inflate(R.layout.card_view, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.btn_cat.text = mListCat.categories?.get(position)?.strCategory ?: ""
        items.add(holder.card)

        holder.btn_cat.setOnClickListener{
            bar(holder.btn_cat.text as String)
        }
    }

    override fun getItemCount(): Int {
        return mListCat.categories?.size ?: 0
    }

    inner class ViewHolder internal constructor(itemView: View)
        : RecyclerView.ViewHolder(itemView){
            val btn_cat: Button = itemView.findViewById(R.id.cat_btn)
            val card: CardView = itemView.findViewById(R.id.card)
        }
}