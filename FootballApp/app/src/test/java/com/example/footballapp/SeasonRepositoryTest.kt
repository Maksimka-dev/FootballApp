package com.example.footballapp

// import androidx.room.Room
// import com.example.footballapp.data.database.AppDatabase
// import com.example.footballapp.data.model.SeasonRepositoryImpl
// import com.example.footballapp.data.network.NetworkApi
// import com.example.footballapp.di.AppModule
// import kotlinx.coroutines.runBlocking
// import org.junit.Assert
// import org.junit.Test
//
// class SeasonRepositoryTest {
//
//    @Test
//    fun `check that Liverpool FC in Championship Of 2018 had position 2`() = runBlocking {
//        val retrofit = AppModule().provideRetrofit()
//        val database = Room.databaseBuilder(
//          MyApplication().applicationContext, AppDatabase::class.java, "season_database"
//        ).build()
//        val season2018 =
//            SeasonRepositoryImpl(retrofit.create(NetworkApi::class.java), database).getSeason(2018)
//        val team = season2018?.find {
//            it.position == 2
//        }?.teamName
//        Assert.assertEquals(team, "Liverpool FC")
//    }
// }
