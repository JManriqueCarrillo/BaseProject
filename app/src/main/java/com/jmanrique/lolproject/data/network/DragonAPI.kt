package com.jmanrique.lolproject.data.network

import com.jmanrique.lolproject.data.network.model.championDetail.WSChampionDetail
import com.jmanrique.lolproject.data.network.model.championSummary.WSChampionSummary
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface DragonAPI {

    @GET("latest/plugins/rcp-be-lol-game-data/global/es_es/v1/champion-summary.json")
    fun getChampionSummary(): Single<List<WSChampionSummary>>

    @GET("latest/plugins/rcp-be-lol-game-data/global/es_es/v1/champions/{id}.json")
    fun getChampionDetail(id: String): Single<WSChampionDetail>

}