package com.jmanrique.lolproject.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jmanrique.lolproject.data.local.DragonDAO
import com.jmanrique.lolproject.data.local.model.DBChampionSummary

@Database(entities = [DBChampionSummary::class], version = 1)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun getDragonDao(): DragonDAO
}