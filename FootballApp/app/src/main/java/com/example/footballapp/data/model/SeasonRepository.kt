package com.example.footballapp.data.model

interface SeasonRepository {
    suspend fun getSeason(seasonStartYear: Int): List<SeasonItem>?
}
