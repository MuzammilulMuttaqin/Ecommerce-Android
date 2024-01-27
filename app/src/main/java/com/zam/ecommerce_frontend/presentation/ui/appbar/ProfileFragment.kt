package com.zam.ecommerce_frontend.presentation.ui.appbar

import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.ThumbnailUtils
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.navigation.fragment.findNavController
import android.Manifest
import android.content.ContentResolver
import android.net.Uri
import android.text.method.LinkMovementMethod
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentProfileBinding
import com.zam.ecommerce_frontend.presentation.utils.Constant
import com.zam.ecommerce_frontend.presentation.utils.ImageSaver
import com.zam.ecommerce_frontend.presentation.utils.Utils.customTextColor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

@Suppress("DEPRECATION")
class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding as FragmentProfileBinding
    private var imageFile : File? = null
    private var imageMultiPart: MultipartBody.Part? = null
    private var imageUri: Uri? = Uri.EMPTY
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

    private fun initView() {
        binding.apply {
            ivProfileImage.setImageResource(R.drawable.ic_person)
            fieldName.hint = getString(R.string.selesai)
            btnSelesai.text = getString(R.string.selesai)

        }
    }

    private fun setTvPersyaratan(){
        with(binding) {

        }
        with(binding){
            tvPersyaratan.movementMethod = LinkMovementMethod.getInstance()
            val color = context?.let { ContextCompat.getColor(it, R.color.primary) }

            val actionInc : () -> Unit = {
                Intent(Intent.ACTION_VIEW, Constant.linkTvPersyaratan.toUri()).run {
                    context?.startActivity(this)
                }
            }
            val actionPolicy : () -> Unit = {
                Intent(Intent.ACTION_VIEW, Constant.linkTvPersyaratan.toUri()).run {
                    context?.startActivity(this)
                }
            }

            if (color != null){
                tvPersyaratan.text = getString(R.string.SnK).customTextColor(
                    resources.configuration.locales[0].language,
                    color,
                    actionInc,
                    actionPolicy
                )
            }
        }

    }

    private fun showImagePickerDialog() {
        val options = arrayOf(getString(R.string.kamera), getString(R.string.galeri))

        val builder = AlertDialog.Builder(context)
        builder.setTitle(getString(R.string.pilih_gambar))

        builder.setItems(options) { _, which ->
            when (which) {
                0 -> takePictureFromCamera()
                1 -> pickImageFromGallery()
            }
        }
        builder.show()
    }

    private fun takePictureFromCamera() {
        if (checkSelfPermission(
                requireActivity(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 1)
        } else {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), 100)
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            var image = data!!.extras!!["data"] as Bitmap?
            val dimension = image!!.width.coerceAtMost(image.height)
            image = ThumbnailUtils.extractThumbnail(image, dimension, dimension)
            val imageSaver = ImageSaver(requireActivity())
            imageSaver.saveBitmapToGallery(image)
            with(binding) {
                ivProfileImage.setImageBitmap(image)
                ivProfileImage.scaleType = ImageView.ScaleType.CENTER_CROP
            }
            Toast.makeText(requireActivity(), "camera $image", Toast.LENGTH_SHORT).show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun pickImageFromGallery(){
        galleryLauncher.launch("image/*")
    }
    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                val contentResolver: ContentResolver = requireActivity().contentResolver
                val type = contentResolver.getType(it)
                imageUri = it
                val fileNameImg = "${System.currentTimeMillis()}.png"
                binding.ivProfileImage.setImageURI(it)
                binding.ivProfileImage.scaleType = ImageView.ScaleType.CENTER_CROP
                val tempFile = File.createTempFile(Constant.tempFile, fileNameImg, null)
                imageFile = tempFile
                val inputStream = contentResolver.openInputStream(uri)
                tempFile.outputStream().use { result ->
                    inputStream?.copyTo(result)
                }
                val requestBody: RequestBody = tempFile.asRequestBody(type?.toMediaType())
                imageMultiPart = MultipartBody.Part.createFormData(Constant.multipartImage, tempFile.name, requestBody)
            }
        }

}