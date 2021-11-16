package com.jmanrique.lolproject.app.di.module

import com.jmanrique.lolproject.app.repository.DefaultRepository
import com.jmanrique.lolproject.data.local.DragonDAO
import com.jmanrique.lolproject.data.network.DragonAPI
import com.jmanrique.lolproject.data.repository.DragonLocalStoreImpl
import com.jmanrique.lolproject.data.repository.DragonRemoteStoreImpl
import com.jmanrique.lolproject.domain.repository.DataStore
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
    fun providesDragonRepository(localStore: DragonLocalStoreImpl, remoteStore: DragonRemoteStoreImpl): DragonRepository = DefaultRepository(localStore, remoteStore)

    @Singleton
    @Provides
    fun provideRemoteDragonRepository(api: DragonAPI): DataStore = DragonRemoteStoreImpl(api)

    @Singleton
    @Provides
    fun provideLocalDragonRepository(dao: DragonDAO): DataStore = DragonLocalStoreImpl(dao)

}