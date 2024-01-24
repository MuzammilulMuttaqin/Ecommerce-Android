package com.zam.ecommerce_frontend.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentMainBinding
import com.zam.ecommerce_frontend.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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
        binding.topAppBar.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_profileFragment)
        }
        val navHostFragment = childFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavView.setupWithNavController(navController)
        binding.bottomNavView.setOnItemSelectedListener { menuItem->
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
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appbar_menu, menu)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        binding.topAppBar.logo
        return when (item.itemId) {
            R.id.topAppBar -> {
                // Navigate to settings screen.
                true
            }
            R.id.appbar_notification -> {
                // Save profile changes.
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}