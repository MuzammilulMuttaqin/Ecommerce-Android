package com.zam.ecommerce_frontend.presentation.di

import com.zam.ecommerce_frontend.presentation.data.local.datastore.UserPreferenceDataSource
import com.zam.ecommerce_frontend.presentation.data.local.datastore.UserPreferenceDataSourceImpl
import com.zam.ecommerce_frontend.presentation.data.local.datastore.userDataSource
import com.zam.ecommerce_frontend.presentation.utils.PreferenceDataStoreHelper
import com.zam.ecommerce_frontend.presentation.utils.PreferenceDataStoreHelperImpl
import org.koin.android.ext.koin.androidContext
import com.zam.ecommerce_frontend.presentation.ui.home.HomeViewModel
import com.zam.ecommerce_frontend.presentation.ui.onboarding.OnboardingViewModel

import org.koin.dsl.module
import org.koin.core.module.Module
import org.koin.androidx.viewmodel.dsl.viewModelOf


object AppModules {

    private val local = module {
        single { androidContext().userDataSource }
        single<PreferenceDataStoreHelper> { PreferenceDataStoreHelperImpl(get()) }
    }
    private val dataSourceModule = module {
        single<UserPreferenceDataSource> { UserPreferenceDataSourceImpl(get()) }
    }
    private val viewModelModule = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::OnboardingViewModel)
    }
    val modules: List<Module> = listOf(
        local,
        dataSourceModule,
        viewModelModule,
    )
}