package com.zam.ecommerce_frontend.presentation.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.zam.ecommerce_frontend.R
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ImageSaver(private val context: Context) {
    fun saveBitmapToGallery(bitmap: Bitmap) {
        val fileName = generateFileName()
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.WIDTH, bitmap.width)
            put(MediaStore.Images.Media.HEIGHT, bitmap.height)
        }

        val resolver = context.contentResolver
        val uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

        try {
            if (uri != null) {
                resolver.openOutputStream(uri)?.use { outputStream ->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                    Toast.makeText(context,
                        context.getString(R.string.gambar_disimpan_ke_galeri), Toast.LENGTH_SHORT).show()
                    Toast.makeText(context,
                        context.getString(R.string.gambar_disimpan, fileName), Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context,
                context.getString(R.string.gambar_gagal_disimpan), Toast.LENGTH_SHORT).show()
        }

        MediaScannerConnection.scanFile(
            context,
            arrayOf(uri?.path),
            arrayOf("image/jpeg"),
            null
        )
        Log.d(context.getString(R.string.imagesaver), uri.toString())
    }

    private fun generateFileName(): String {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        return "IMG_$timeStamp.jpg"
    }
}