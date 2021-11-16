package com.jmanrique.lolproject.app.di.module

import com.jmanrique.lolproject.data.network.DragonAPI
import com.jmanrique.lolproject.data.repository.DragonRemoteRepositoryImpl
import com.jmanrique.lolproject.domain.repository.DragonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDragonRepository(api: DragonAPI): DragonRepository = DragonRemoteRepositoryImpl(api)

}