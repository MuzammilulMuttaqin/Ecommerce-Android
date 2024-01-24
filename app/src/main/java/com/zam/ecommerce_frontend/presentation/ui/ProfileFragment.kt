package com.zam.ecommerce_frontend.presentation.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding as FragmentProfileBinding
    private val takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val imageBitmap = result.data?.extras?.get("data") as? Bitmap
                binding.ivProfileImage.setImageBitmap(imageBitmap)
                binding.ivProfileImage.scaleType = ImageView.ScaleType.CENTER_CROP

            }
        }

    private val pickFromGalleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val imageUri = result.data?.data
                binding.ivProfileImage.setImageURI(imageUri)
                binding.ivProfileImage.scaleType = ImageView.ScaleType.CENTER_CROP
            }
        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.ivProfileImage.setOnClickListener {
            showImagePickerDialog()
        }
        binding.btnSelesai.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_mainFragment)
        }
    }
    private fun initView() = with(binding){
            ivProfileImage.setImageResource(R.drawable.ic_person)
            fieldName.hint = getString(R.string.selesai)
            btnSelesai.text = getString(R.string.selesai)
            tvPersyaratan.text = getString(R.string.SnK)
    }
    private fun showImagePickerDialog() {
        val options = arrayOf("Kamera", "Galeri")

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Pilih Gambar")

        builder.setItems(options) { _, which ->
            when (which) {
                0 -> takePictureFromCamera()
                1 -> pickImageFromGallery()
            }
        }

        builder.show()
    }
    private fun takePictureFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureLauncher.launch(intent)
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickFromGalleryLauncher.launch(intent)
    }
    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}