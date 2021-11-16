package com.jmanrique.lolproject.data.repository

import com.jmanrique.lolproject.data.local.DragonDAO
import com.jmanrique.lolproject.domain.repository.DataStore
import com.jmanrique.lolproject.domain.entities.ChampionSummary
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DragonLocalStoreImpl @Inject constructor(
    private val dragonDAO: DragonDAO
): DataStore {

    override fun getChampionSummary(): Single<List<ChampionSummary>> =
        dragonDAO.getChampionSummary().map { list ->
            list.map { champion ->
                champion.toChampionSummary()
            }
        }


}