package com.jmanrique.lolproject.app.repository

import android.content.Context
import android.util.Log
import com.jmanrique.lolproject.data.repository.DragonLocalStoreImpl
import com.jmanrique.lolproject.data.repository.DragonRemoteStoreImpl
import com.jmanrique.lolproject.domain.entities.ChampionSummary
import com.jmanrique.lolproject.domain.repository.DragonRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class DefaultRepository @Inject constructor(
    private val localStore: DragonLocalStoreImpl,
    private val remoteStore: DragonRemoteStoreImpl
) : DragonRepository {

    override fun getChampionSummary(): Single<List<ChampionSummary>> {


        localStore.getChampionSummary().map {
            Log.d("DEFAULT_REPOSITORY", "${it.toString()}")
        }.doOnError {
            Log.d("DEFAULT_REPOSITORY", "OnError")
        }.doOnSuccess {
            Log.d("DEFAULT_REPOSITORY", "OnSuccess")
        }

        return Single.just(ArrayList())
    }
}