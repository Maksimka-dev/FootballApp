package com.example.footballapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SeasonItemDatabaseDao {
    @Query("SELECT * FROM season_table")
    fun getCashedTable(): LiveData<List<SeasonItemDatabase>>

    @Insert
    fun insertAll(seasonItemDatabase: List<SeasonItemDatabase>)

    @Query("DELETE FROM season_table")
    fun deleteAllFromTable()
}
