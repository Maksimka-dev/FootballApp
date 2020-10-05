package com.example.footballapp.presentation.season.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.footballapp.R
import com.example.footballapp.data.model.SeasonItem
import com.example.footballapp.databinding.SeasonRecyclerviewItemBinding

class SeasonAdapter(
    owner: LifecycleOwner,
    liveData: LiveData<List<SeasonItem>?>
) : RecyclerView.Adapter<SeasonViewHolder>() {

    private val items = mutableListOf<SeasonItem>()

    init {
        liveData.observe(owner, Observer {
            it ?: return@Observer
            this.addItems(it)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val binding =
            SeasonRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context))
        return SeasonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        val listItem = items[position]
        holder.teamPosition.text = listItem.position.toString()
        val glideUrl = GlideUrl(
            listItem.teamImage, LazyHeaders.Builder()
                .addHeader("X-Auth-Token", "231366f27e944e4b8de3fd55de255947")
                .build()
        ).toStringUrl()
        Glide.with(holder.teamImage.context)
            .load(glideUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_download)
            .into(holder.teamImage)
        holder.teamName.text = listItem.teamName
        holder.playedGames.text = listItem.playedGames.toString()
        holder.won.text = listItem.won.toString()
        holder.draw.text = listItem.draw.toString()
        holder.lost.text = listItem.lost.toString()
        holder.points.text = listItem.points.toString()
    }

    private fun addItems(newItems: List<SeasonItem>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
