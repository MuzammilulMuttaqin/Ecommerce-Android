package com.zam.ecommerce_frontend.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentMainBinding
class MainFragment : Fragment() {
    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding as FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(binding.mainFragment.id) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavView
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnItemSelectedListener { menuItem->
            when(menuItem.itemId){
                R.id.bottomHome ->{
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.bottomStore ->{
                    navController.navigate(R.id.storeFragment)
                    true
                }
                R.id.bottomWishlist->{
                    navController.navigate(R.id.wishlistFragment)
                    true
                }
                R.id.bottomTransaction ->{
                    navController.navigate(R.id.transactionFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}