package com.zam.ecommerce_frontend.presentation.data.model.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Keep
@Parcelize
data class ProfileResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String
) : Parcelable {
    @Keep
    @Parcelize
    data class Data(
        @SerializedName("userImage")
        val userImage: String,
        @SerializedName("userName")
        val userName: String
    ) : Parcelable
}