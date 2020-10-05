package com.example.footballapp.data.model

interface WinnersRepository {
    suspend fun getListOfWinners(): List<WinnersItem>?
}
