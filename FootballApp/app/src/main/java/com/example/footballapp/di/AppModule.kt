package com.example.footballapp.di

import com.example.footballapp.data.model.SeasonRepository
import com.example.footballapp.data.model.SeasonRepositoryImpl
import com.example.footballapp.data.model.WinnersRepository
import com.example.footballapp.data.model.WinnersRepositoryImpl
import com.example.footballapp.data.network.NetworkApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class AppModule() {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api.football-data.org/")
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): NetworkApi {
        return retrofit.create(NetworkApi::class.java)
    }

    @Singleton
    @Provides
    fun getRepository(repository: WinnersRepositoryImpl): WinnersRepository {
        return repository
    }

    @Singleton
    @Provides
    fun getTableRepository(repository: SeasonRepositoryImpl): SeasonRepository {
        return repository
    }
}
