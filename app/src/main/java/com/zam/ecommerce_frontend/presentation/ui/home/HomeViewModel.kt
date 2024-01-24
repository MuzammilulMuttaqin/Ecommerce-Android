package com.zam.ecommerce_frontend.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.zam.ecommerce_frontend.presentation.data.local.datastore.UserPreferenceDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val userPreferenceDataSource: UserPreferenceDataSource): ViewModel(){
    val appThemeLiveData = userPreferenceDataSource.getStateDarkMode().asLiveData(Dispatchers.IO)
    fun setThemeDarkMode(isActive : Boolean){
        viewModelScope.launch {
            userPreferenceDataSource.saveStateDarkMode(isActive)
        }
    }
}