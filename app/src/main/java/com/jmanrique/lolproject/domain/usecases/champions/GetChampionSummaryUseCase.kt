package com.jmanrique.lolproject.domain.usecases.champions

import com.jmanrique.lolproject.domain.entities.ChampionSummary
import com.jmanrique.lolproject.domain.usecases.SingleUseCase

interface GetChampionSummaryUseCase: SingleUseCase<Void, List<ChampionSummary>>{
}