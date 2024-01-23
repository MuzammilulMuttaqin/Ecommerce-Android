package com.zam.ecommerce_frontend.presentation.data.local.datastore

//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.edit
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//
//interface UserPreferenceDataSource {
//    fun getStateDarkmode(): Flow<Boolean>
//    suspend fun saveStateDarkmode(isActive: Boolean)
//}
//
//@Suppress("UNCHECKED_CAST")
//class UserPreferenceDataSourceImpl(
//    private val dataStore: DataStore<Preferences>,
////    private val gson: Gson
//): UserPreferenceDataSource {
//    override fun getStateDarkmode(): Flow<Boolean> {
//        return dataStore.data.map {
//            it.toPreferences()[UserPreferenceKey.darkMode] ?: false
//        } as Flow<Boolean>
//    }
//
//    override suspend fun saveStateDarkmode(darkMode: Boolean) {
//        dataStore.edit {
//            it[UserPreferenceKey.darkMode] = darkMode.toString()
//        }
//    }
//}
