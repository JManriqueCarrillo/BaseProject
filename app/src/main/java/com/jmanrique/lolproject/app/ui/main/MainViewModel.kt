package com.jmanrique.lolproject.app.ui.main

import android.content.Context
import com.jmanrique.lolproject.app.ui.base.BaseViewModel
import com.jmanrique.lolproject.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context
) : BaseViewModel() {

    val showLoading = SingleLiveEvent<Boolean>().apply { value = false }

}