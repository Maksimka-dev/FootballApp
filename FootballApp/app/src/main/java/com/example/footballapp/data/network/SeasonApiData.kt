package com.example.footballapp.data.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SeasonApiData(
    @Json(name = "standings") val standings: List<Standing>
)

@JsonClass(generateAdapter = true)
data class Standing(
    @Json(name = "table") val tableList: List<TableLine>,
    @Json(name = "type") val type: String?
)

@JsonClass(generateAdapter = true)
data class TableLine(
    @Json(name = "team") val teamInfo: TeamInfo?,
    @Json(name = "position") val position: Int?,
    @Json(name = "playedGames") val playedGames: Int?,
    @Json(name = "won") val won: Int?,
    @Json(name = "draw") val draw: Int?,
    @Json(name = "lost") val lost: Int?,
    @Json(name = "points") val points: Int?
)

@JsonClass(generateAdapter = true)
data class TeamInfo(
    @Json(name = "name") val teamName: String?,
    @Json(name = "crestUrl") val teamImage: String?
)
