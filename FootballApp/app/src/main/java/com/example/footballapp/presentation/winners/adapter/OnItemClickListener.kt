package com.example.footballapp.presentation.winners.adapter

import com.example.footballapp.data.model.WinnersItem

interface OnItemClickListener {
    fun onItemClicked(winner: WinnersItem)
}
