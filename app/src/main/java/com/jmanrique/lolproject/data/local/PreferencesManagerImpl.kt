package com.jmanrique.lolproject.data.local

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PreferencesManagerImpl @Inject constructor(
    @ApplicationContext context: Context
) : PreferencesManager {

    companion object {
        const val USER_DATA_KEY = "USER_DATA"
        const val USER_CREDENTIALS_KEY = "USER_CREDENTIALS_DATA"
        const val TERMS_KEY = "TERMS_KEY"
    }

    private val manager = context.getSharedPreferences("DATA_PREFERENCES", Context.MODE_PRIVATE)

    override fun deleteSession(): Completable =
        Completable.defer {
            manager.edit {
                putString(USER_DATA_KEY, "")
                putString(USER_CREDENTIALS_KEY, "")
                commit()
            }
            Completable.complete()
        }

    override fun isTermsRead(): Single<Boolean> = Single.defer {
        Single.just(manager.getBoolean(TERMS_KEY, false))
    }

}