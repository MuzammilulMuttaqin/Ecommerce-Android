package com.zam.ecommerce_frontend.presentation.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.userDataSource by preferencesDataStore(
    name = "appPreference"
)