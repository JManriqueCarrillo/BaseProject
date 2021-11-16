package com.jmanrique.lolproject.data.local

import androidx.room.Dao
import androidx.room.Query
import com.jmanrique.lolproject.data.local.model.DBChampionSummary
import com.jmanrique.lolproject.data.network.model.championSummary.WSChampionSummary
import com.jmanrique.lolproject.domain.entities.ChampionSummary
import io.reactivex.rxjava3.core.Single

@Dao
interface DragonDAO{

    @Query("SELECT * FROM championSummary")
    fun getChampionSummary(): Single<List<DBChampionSummary>>

}