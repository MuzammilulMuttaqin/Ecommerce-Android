package com.zam.ecommerce_frontend.presentation.ui.store

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zam.ecommerce_frontend.databinding.FragmentBottomSheetStoreBinding

class BottomSheetStore : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetStoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBottomSheetStoreBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}