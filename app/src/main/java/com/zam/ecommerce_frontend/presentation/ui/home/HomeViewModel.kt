package com.zam.ecommerce_frontend.presentation.ui.home
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.zam.ecommerce_frontend.presentation.data.local.datastore.UserPreferenceDataSource
//import kotlinx.coroutines.launch
//
//class HomeViewModel(private val userPreferenceDataSource: UserPreferenceDataSource): ViewModel(){
//    val appThemeLiveData = userPreferenceDataSource.getStateDarkmode()
//
//    fun setThemeDarkmode(isActive : Boolean){
//        viewModelScope.launch {
//            userPreferenceDataSource.saveStateDarkmode(isActive)
//        }
//    }
//}