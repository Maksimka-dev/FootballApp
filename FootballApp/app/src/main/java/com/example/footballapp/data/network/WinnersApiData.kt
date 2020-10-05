package com.example.footballapp.data.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WinnersApiData(
    @Json(name = "seasons") val seasons: List<Season>
)

@JsonClass(generateAdapter = true)
data class Season(
    @Json(name = "winner") val winner: Winner?,
    @Json(name = "startDate") val seasonStartDate: String?,
    @Json(name = "endDate") val seasonEndDate: String?
)

@JsonClass(generateAdapter = true)
data class Winner(
    @Json(name = "name") val winnerName: String?,
    @Json(name = "crestUrl") val imageUrl: String?
)
