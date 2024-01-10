package com.example.tvmazeproject.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tvmazeproject.R
import com.example.tvmazeproject.api.response.ResponseCastItem

class CastAdapter(private val listCast: List<ResponseCastItem>) : RecyclerView.Adapter<CastAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ImageView = view.findViewById(R.id.iv_photo_cast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cast, parent, false))

    override fun getItemCount() = listCast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listCast[position].person.image.medium)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivPhoto)
    }
}