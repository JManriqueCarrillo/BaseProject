package com.jmanrique.lolproject.domain.usecases.champions

import com.jmanrique.lolproject.domain.entities.ChampionSummary
import com.jmanrique.lolproject.domain.repository.DragonRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetChampionSummaryUseCaseImpl @Inject constructor(
    private val DragonRepository: DragonRepository
): GetChampionSummaryUseCase {

    override fun execute(aVoid: Void?): Single<List<ChampionSummary>> {
        return DragonRepository.getChampionSummary()
    }
}