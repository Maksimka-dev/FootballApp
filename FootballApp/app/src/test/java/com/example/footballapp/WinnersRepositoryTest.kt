package com.example.footballapp

// import com.example.footballapp.data.model.WinnersRepositoryImpl
// import com.example.footballapp.data.network.NetworkApi
// import com.example.footballapp.di.AppModule
// import kotlinx.coroutines.runBlocking
// import org.junit.Assert
// import org.junit.Test
//
// class WinnersRepositoryTest {
//
//    @Test
//    fun `check that Champion Of 2018 is Manchester City`() = runBlocking {
//        val retrofit = AppModule().provideRetrofit()
//        val champList =
//            WinnersRepositoryImpl(
//                retrofit.create(NetworkApi::class.java),
//                MyApplication().applicationContext
//            ).getListOfWinners()
//        val team = champList?.find {
//            it.year == 2018
//        }?.winnerTeam
//        Assert.assertEquals(team, "Manchester City FC")
//    }
// }
