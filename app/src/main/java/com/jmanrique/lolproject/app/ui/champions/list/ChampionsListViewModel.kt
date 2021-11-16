package com.jmanrique.lolproject.app.ui.champions.list

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jmanrique.lolproject.app.ui.base.BaseViewModel
import com.jmanrique.lolproject.domain.entities.ChampionSummary
import com.jmanrique.lolproject.domain.usecases.champions.GetChampionSummaryUseCase
import com.jmanrique.lolproject.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChampionsListViewModel @Inject constructor(
    private val context: Context,
    private val getChampionSummaryUseCase: GetChampionSummaryUseCase
) : BaseViewModel() {

    val showLoading = SingleLiveEvent<Boolean>().apply { value = false }
    val championSummaryList = MutableLiveData<List<ChampionSummary>>()

    fun getChampionSummary() {
//        showLoading.value = true
        Log.d("CHAMPION_LIST", "Get Champion summary")
        subscribe(getChampionSummaryUseCase.execute(null), {
            Log.d("CHAMPION_LIST", it.toString())
            championSummaryList.value = it.filter { champion -> champion.id != -1 }
//            showLoading.value = false
        }, {
            Log.d("CHAMPION_LIST", "Error obtaining champion summary")
//            showLoading.value = false
        })
    }

}