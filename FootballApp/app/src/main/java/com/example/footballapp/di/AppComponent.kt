package com.example.footballapp.di

import android.content.Context
import com.example.footballapp.data.database.AppDatabase
import com.example.footballapp.presentation.season.SeasonViewModel
import com.example.footballapp.presentation.winners.WinnersViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, @BindsInstance database: AppDatabase): AppComponent
    }

    fun inject(winnersViewModel: WinnersViewModel)
    fun inject(seasonViewModel: SeasonViewModel)
}
