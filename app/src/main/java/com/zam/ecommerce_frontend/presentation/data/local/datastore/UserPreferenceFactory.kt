package com.zam.ecommerce_frontend.presentation.data.local.datastore
//
//import android.content.Context
//import androidx.datastore.core.DataStore
//import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
//import androidx.datastore.preferences.core.PreferenceDataStoreFactory
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.emptyPreferences
//import androidx.datastore.preferences.core.stringPreferencesKey
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.SupervisorJob
//import androidx.datastore.preferences.preferencesDataStoreFile
//
//
//class UserPreferenceFactory(private val appContext: Context){
//    fun create(): DataStore<Preferences> {
//        return PreferenceDataStoreFactory.create(
//            corruptionHandler = ReplaceFileCorruptionHandler(
//                produceNewData = { emptyPreferences() }
//            ),
//            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
//            produceFile = { appContext.preferencesDataStoreFile(USER_PREFERENCE)}
//
//
//        )
//    }
//    companion object{
//        const val USER_PREFERENCE = "user_preferences"
//    }
//}
//object  UserPreferenceKey{
//    val darkMode = stringPreferencesKey(PreferenceKey.STATE_DARK_MODE)
//}
//object PreferenceKey{
//    const val STATE_DARK_MODE = "STATE_DARK_MODE"
//}