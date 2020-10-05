package com.example.footballapp.data.network

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetworkApi {
    @Headers(
        "X-Auth-Token: 231366f27e944e4b8de3fd55de255947",
        "Content-type: application/json"
    )
    @GET("/v2/competitions/2021")
    suspend fun getListOfWinners(): WinnersApiData

    @Headers(
        "X-Auth-Token: 231366f27e944e4b8de3fd55de255947",
        "Content-type: application/json"
    )
    @GET("/v2/competitions/2021/standings")
    suspend fun getSeasonTable(@Query("season") seasonStartYear: Int): SeasonApiData
}
