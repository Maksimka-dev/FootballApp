package com.example.footballapp.presentation.winners.adapter

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
import com.example.footballapp.data.model.WinnersItem
import com.example.footballapp.databinding.WinnersRecyclerviewItemBinding

class WinnersAdapter(
    owner: LifecycleOwner,
    liveData: LiveData<List<WinnersItem>>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<WinnersViewHolder>() {

    private val items = mutableListOf<WinnersItem>()

    init {
        liveData.observe(owner, Observer {
            it ?: return@Observer
            this.addItems(it)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WinnersViewHolder {
        val binding = WinnersRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context))
        return WinnersViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: WinnersViewHolder, position: Int) {
        val listItem = items[position]
        holder.champYear.text = listItem.year.toString()
        if (listItem.winnerTeam != null) {
            holder.champTeam.text = listItem.winnerTeam
        } else {
            holder.champTeam.text = "No information about Champion"
        }
        if (listItem.winnerTeamImage != null) {
            val glideUrl = GlideUrl(
                listItem.winnerTeamImage, LazyHeaders.Builder()
                    .addHeader("X-Auth-Token", "231366f27e944e4b8de3fd55de255947")
                    .build()
            )
            Glide.with(holder.champTeamImage.context)
                .load(glideUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_download)
                .into(holder.champTeamImage)
        } else {
            holder.champTeamImage.setImageResource(R.drawable.ic_error)
        }
        holder.itemView.setOnClickListener { listener.onItemClicked(listItem) }
    }

    private fun addItems(newItems: List<WinnersItem>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
