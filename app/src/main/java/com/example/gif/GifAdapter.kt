package com.example.gif

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gif.DataClasses.Data

class GifAdapter(private val gif:ArrayList<Data>):RecyclerView.Adapter<GifAdapter.GifViewHolder>() {

    class GifViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView =view.findViewById(R.id.iView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val holder = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.form, parent, false)
        return GifViewHolder(holder)
    }
    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
     val source= gif[position]
        Glide.with(holder.view.context)
            .load(source.images.image.urlImage)
            .centerCrop()
            .into(holder.image)
    }
    override fun getItemCount(): Int {
        return gif.size
    }
}