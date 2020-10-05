package com.example.footballapp.data.model

import android.content.Context
import android.widget.Toast
import com.example.footballapp.data.network.NetworkApi
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WinnersRepositoryImpl @Inject constructor(
    private val teamWinnerApiService: NetworkApi,
    private val context: Context
) : WinnersRepository {

    override suspend fun getListOfWinners(): List<WinnersItem>? {
        var winnersList: List<WinnersItem>? = null
        try {
            winnersList = withContext(Dispatchers.IO) {
                Mapper.mapWinners(teamWinnerApiService.getListOfWinners().seasons)
            }
        } catch (e: IOException) {
            Toast.makeText(
                context,
                "Check internet connection and restart Football App",
                Toast.LENGTH_SHORT
            ).show()
        }
        return winnersList
    }
}
