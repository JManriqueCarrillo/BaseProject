package com.jmanrique.lolproject.data.local

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface PreferencesManager {
    fun deleteSession(): Completable
    fun isTermsRead(): Single<Boolean>
}