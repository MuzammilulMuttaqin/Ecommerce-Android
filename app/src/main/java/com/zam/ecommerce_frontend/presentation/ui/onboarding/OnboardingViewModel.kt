package com.zam.ecommerce_frontend.presentation.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.zam.ecommerce_frontend.presentation.data.local.datastore.UserPreferenceDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnboardingViewModel(private val userPreferenceDataSource: UserPreferenceDataSource):ViewModel() {
    val appOnboardingLiveData = userPreferenceDataSource.getStateOnboarding().asLiveData(Dispatchers.IO)

    fun setStateOnboarding(isActive : Boolean){
        viewModelScope.launch {
            userPreferenceDataSource.saveStateOnboarding(isActive)
        }
    }
}