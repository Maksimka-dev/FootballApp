package com.example.footballapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "season_table")
data class SeasonItemDatabase(
    @PrimaryKey
    @ColumnInfo(name = "cashedPosition") val cashedPosition: Int?,
    @ColumnInfo(name = "cashedTeamEmblem") val cashedTeamEmblem: String?,
    @ColumnInfo(name = "cashedTeamName") val cashedTeamName: String?,
    @ColumnInfo(name = "cashedPlayedGames") val cashedPlayedGames: Int?,
    @ColumnInfo(name = "cashedWonGames") val cashedWonGames: Int?,
    @ColumnInfo(name = "cashedDrawGames") val cashedDrawGames: Int?,
    @ColumnInfo(name = "cashedLostGames") val cashedLostGames: Int?,
    @ColumnInfo(name = "cashedPoints") val cashedPoints: Int?
)
