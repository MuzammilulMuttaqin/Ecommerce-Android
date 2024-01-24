package com.zam.ecommerce_frontend.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel : HomeViewModel by viewModel()

    private val binding get() = _binding as FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnLogout.text = getString(R.string.logout)
            tvEn.text = getString(R.string.en)
            tvId.text = getString(R.string.id)
            tvDark.text = getString(R.string.dark)
            tvLight.text = getString(R.string.light)
        }
        viewModel.appThemeLiveData.observe(viewLifecycleOwner){ isActive ->
            binding.switchDarkmode.isChecked = isActive
        }
        binding.switchDarkmode.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setThemeDarkMode(isChecked)
        }

    }
}