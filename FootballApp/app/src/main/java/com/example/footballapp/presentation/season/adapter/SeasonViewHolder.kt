package com.example.footballapp.presentation.season.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.databinding.SeasonRecyclerviewItemBinding

class SeasonViewHolder(binding: SeasonRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val teamPosition = binding.idTablePosition
    val teamImage = binding.idTableTeamImage
    val teamName = binding.idTableTeamName
    val playedGames = binding.idTablePlayedGames
    val won = binding.idTableWonGames
    val draw = binding.idTableDrawGames
    val lost = binding.idTableLostGames
    val points = binding.idTablePoints
}
