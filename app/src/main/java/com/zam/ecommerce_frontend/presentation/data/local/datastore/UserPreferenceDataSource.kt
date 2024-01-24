package com.zam.ecommerce_frontend.presentation.data.local.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import com.zam.ecommerce_frontend.presentation.utils.PreferenceDataStoreHelper
import kotlinx.coroutines.flow.Flow

interface UserPreferenceDataSource {
    fun getStateDarkMode(): Flow<Boolean>
    suspend fun saveStateDarkMode(isActive: Boolean)
}
class UserPreferenceDataSourceImpl(private val preferenceHelper: PreferenceDataStoreHelper): UserPreferenceDataSource{
    override fun getStateDarkMode(): Flow<Boolean> {
        return preferenceHelper.getPreference(STATE_DARK_MODE, false)
    }

    override suspend fun saveStateDarkMode(isActive: Boolean) {
        return preferenceHelper.putPreference(STATE_DARK_MODE, isActive)

    }
    companion object {
        val STATE_DARK_MODE = booleanPreferencesKey("STATE_DARK_MODE")
    }

}
