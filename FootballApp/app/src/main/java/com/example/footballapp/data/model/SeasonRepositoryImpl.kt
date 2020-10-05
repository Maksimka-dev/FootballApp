package com.example.footballapp.data.model

import com.example.footballapp.data.database.AppDatabase
import com.example.footballapp.data.network.NetworkApi
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SeasonRepositoryImpl @Inject constructor(
    private val seasonApiService: NetworkApi,
    database: AppDatabase
) :
    SeasonRepository {
    private val dao = database.getSeasonItemDatabaseDao()

    override suspend fun getSeason(seasonStartYear: Int): List<SeasonItem>? {

        val seasonItemList = withContext(Dispatchers.IO) {
            val seasonTable = seasonApiService.getSeasonTable(seasonStartYear).standings.find {
                it.type == "TOTAL"
            }?.tableList
            Mapper.mapSeasonTable(seasonTable)
        }

        withContext(Dispatchers.IO) {
            Mapper.mapSeasonTableDatabase(seasonItemList)?.let {
                dao.deleteAllFromTable()
                dao.insertAll(it)
            }
        }
        seasonItemList
        return seasonItemList
    }
}
