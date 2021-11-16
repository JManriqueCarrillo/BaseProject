package com.jmanrique.lolproject.app.di.module

import com.jmanrique.lolproject.domain.usecases.champions.GetChampionSummaryUseCase
import com.jmanrique.lolproject.domain.usecases.champions.GetChampionSummaryUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetChampionSummaryUseCase(impl: GetChampionSummaryUseCaseImpl): GetChampionSummaryUseCase = impl

}