package com.example.footballapp.data.model

import javax.inject.Inject

data class WinnersItem @Inject constructor(
    val year: Int?,
    val winnerTeam: String?,
    val winnerTeamImage: String?,
    val startYear: Int?
)
