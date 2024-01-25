package com.zam.ecommerce_frontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.zam.ecommerce_frontend.databinding.ActivityMainBinding
import com.zam.ecommerce_frontend.presentation.ui.home.HomeViewModel
import com.zam.ecommerce_frontend.presentation.utils.Localization
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel : HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setDarkMode()
        setUpLocalization()
    }
    private fun setDarkMode(){
        viewModel.appThemeLiveData.observe(this){ isActive ->
            when(isActive){
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun setUpLocalization() {
        viewModel.appLocaleLiveData.observe(this){ isActive ->
            when(isActive){
                true -> Localization.setLocale(this, idn)
                else -> Localization.setLocale(this, en)
            }
        }
    }
    companion object {
        val idn = "in"
        val en = "en"
    }
}