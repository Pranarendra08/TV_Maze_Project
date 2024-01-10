package com.example.tvmazeproject.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvmazeproject.R
import com.example.tvmazeproject.api.response.ResponseCastItem

class CastDetailAdapter(private val listCast: List<ResponseCastItem>) : RecyclerView.Adapter<CastDetailAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhotoCastDetail: ImageView = view.findViewById(R.id.iv_cast_detail_photo)
        val tvPersonName: TextView = view.findViewById(R.id.tv_person_name)
        val tvCharacterName : TextView = view.findViewById(R.id.tv_character_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cast_detail, parent, false))

    override fun getItemCount() = listCast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listCast[position].person.image.medium)
            .into(holder.ivPhotoCastDetail)
        holder.tvPersonName.text = listCast[position].person.name
        holder.tvCharacterName.text = "as ${listCast[position].character.name}"
    }
}