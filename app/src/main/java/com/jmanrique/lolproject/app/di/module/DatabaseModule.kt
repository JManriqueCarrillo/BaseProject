package com.jmanrique.lolproject.app.di.module

import android.content.Context
import androidx.room.Room
import com.jmanrique.lolproject.data.local.database.Database
import com.jmanrique.lolproject.data.local.DragonDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideChampionDao(database: Database): DragonDAO = database.getDragonDao()

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext appContext: Context): Database{
        return Room.databaseBuilder(
            appContext,
            Database::class.java,
            "database"
        ).build()
    }

}