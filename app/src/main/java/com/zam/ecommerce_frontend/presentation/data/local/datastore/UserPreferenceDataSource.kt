package com.zam.ecommerce_frontend.presentation.data.local.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import com.zam.ecommerce_frontend.presentation.utils.PreferenceDataStoreHelper
import kotlinx.coroutines.flow.Flow

interface UserPreferenceDataSource {
    fun getStateDarkMode(): Flow<Boolean>
    suspend fun saveStateDarkMode(isActive: Boolean)
    fun getStateLocale(): Flow<Boolean>
    suspend fun saveStateLocale(isActive: Boolean)
    fun getStateOnboarding(): Flow<Boolean>
    suspend fun saveStateOnboarding(isActive: Boolean)
}
class UserPreferenceDataSourceImpl(private val preferenceHelper: PreferenceDataStoreHelper): UserPreferenceDataSource{
    override fun getStateDarkMode(): Flow<Boolean> {
        return preferenceHelper.getPreference(STATE_DARK_MODE, false)
    }

    override suspend fun saveStateDarkMode(isActive: Boolean) {
        return preferenceHelper.putPreference(STATE_DARK_MODE, isActive)

    }

    override fun getStateLocale(): Flow<Boolean> {
        return preferenceHelper.getPreference(STATE_LOCALE, true)
    }

    override suspend fun saveStateLocale(isActive: Boolean) {
        return preferenceHelper.putPreference(STATE_LOCALE, isActive)
    }

    override fun getStateOnboarding(): Flow<Boolean> {
        return preferenceHelper.getPreference(STATE_ONBOARDING, false)
    }

    override suspend fun saveStateOnboarding(isActive: Boolean) {
        return preferenceHelper.putPreference(STATE_ONBOARDING, isActive)
    }

    companion object {
        val STATE_ONBOARDING = booleanPreferencesKey("STATE_ONBOARDING")
        val STATE_LOCALE = booleanPreferencesKey("STATE_LOCALE")
        val STATE_DARK_MODE = booleanPreferencesKey("STATE_DARK_MODE")
    }

}
