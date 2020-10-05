package com.example.footballapp.presentation.winners.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.databinding.WinnersRecyclerviewItemBinding

class WinnersViewHolder(binding: WinnersRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val champYear = binding.idChampYear
    val champTeamImage = binding.idChampTeamImage
    val champTeam = binding.idChampTeam
}
