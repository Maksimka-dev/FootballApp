package com.example.footballapp.data.model

import com.example.footballapp.data.database.SeasonItemDatabase
import com.example.footballapp.data.network.Season
import com.example.footballapp.data.network.TableLine

object Mapper {

    fun mapWinners(seasons: List<Season>): List<WinnersItem> {

        return seasons.map { season ->
            val startDate = season.seasonStartDate?.split("-")
            val seasonStartYear = startDate?.get(0)?.trim()?.toInt()
            val endDate = season.seasonEndDate?.split("-")
            val seasonEndYear = endDate?.get(0)?.trim()?.toInt()
            WinnersItem(
                seasonEndYear,
                season.winner?.winnerName, season.winner?.imageUrl, seasonStartYear
            )
        }
    }

    fun mapSeasonTable(table: List<TableLine>?): List<SeasonItem>? {

        return table?.map { tableLine ->
            SeasonItem(
                tableLine.position,
                tableLine.teamInfo?.teamImage,
                tableLine.teamInfo?.teamName,
                tableLine.playedGames,
                tableLine.won,
                tableLine.draw,
                tableLine.lost,
                tableLine.points
            )
        }
    }

    fun mapSeasonTableDatabase(tableDatabase: List<SeasonItem>?): List<SeasonItemDatabase>? {

        return tableDatabase?.map { tableDatabaseLine ->
            SeasonItemDatabase(
                tableDatabaseLine.position,
                tableDatabaseLine.teamImage,
                tableDatabaseLine.teamName,
                tableDatabaseLine.playedGames,
                tableDatabaseLine.won,
                tableDatabaseLine.draw,
                tableDatabaseLine.lost,
                tableDatabaseLine.points
            )
        }
    }
}
