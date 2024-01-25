package com.zam.ecommerce_frontend.presentation.ui.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.zam.ecommerce_frontend.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {
    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding as FragmentStoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStoreBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.errorView.isVisible = false
        binding.errorView.setErrorMessage(
            title = "500",
            description = "Your requested data is unavailable",
            btnTitle = "error",
            action = {
            }
        )
    }

//    fun showBottomSheet(view: View){
//        val dialog = context?.let { BottomSheetDialog(it) }
//        val view = layoutInflater
//    }

}