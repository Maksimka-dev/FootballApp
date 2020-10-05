package com.example.footballapp

import android.app.Application
import androidx.room.Room
import com.example.footballapp.data.database.AppDatabase
import com.example.footballapp.di.ComponentHolder
import com.example.footballapp.di.DaggerAppComponent

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val database = Room.databaseBuilder(
            this, AppDatabase::class.java, "season_database"
        ).build()
        ComponentHolder.appComponent = DaggerAppComponent.factory().create(this, database)
    }
}
