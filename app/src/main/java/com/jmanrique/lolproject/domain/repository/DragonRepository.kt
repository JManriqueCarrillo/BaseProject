package com.jmanrique.lolproject.domain.repository

import com.jmanrique.lolproject.domain.entities.ChampionSummary
import io.reactivex.rxjava3.core.Single

interface DragonRepository {
    fun getChampionSummary(): Single<List<ChampionSummary>>
}