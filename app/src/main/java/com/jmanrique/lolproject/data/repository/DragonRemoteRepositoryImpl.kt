package com.jmanrique.lolproject.data.repository

import com.jmanrique.lolproject.data.network.DragonAPI
import com.jmanrique.lolproject.domain.entities.ChampionSummary
import com.jmanrique.lolproject.domain.repository.DragonRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DragonRemoteRepositoryImpl @Inject constructor(
    private val dragonAPI: DragonAPI
) : DragonRepository{

    override fun getChampionSummary(): Single<List<ChampionSummary>> {

        //TODO Check if information is in database

        return dragonAPI.getChampionSummary().map { list ->
            list.map { champion ->
                champion.toChampionSummary()
            }
        }
    }

}