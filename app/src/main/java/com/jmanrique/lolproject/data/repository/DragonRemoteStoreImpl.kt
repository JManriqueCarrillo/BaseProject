package com.jmanrique.lolproject.data.repository

import com.jmanrique.lolproject.data.network.DragonAPI
import com.jmanrique.lolproject.domain.repository.DataStore
import com.jmanrique.lolproject.domain.entities.ChampionSummary
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DragonRemoteStoreImpl @Inject constructor(
    private val dragonAPI: DragonAPI
) : DataStore {

    override fun getChampionSummary(): Single<List<ChampionSummary>> =
        dragonAPI.getChampionSummary().map { list ->
            list.map { champion ->
                champion.toChampionSummary()
            }
        }


}