package com.zam.ecommerce_frontend.presentation.data.model.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Keep
@Parcelize
data class LoginResponse(
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
        @SerializedName("accessToken")
        val accessToken: String,
        @SerializedName("expiresAt")
        val expiresAt: Int,
        @SerializedName("refreshToken")
        val refreshToken: String,
        @SerializedName("userImage")
        val userImage: String,
        @SerializedName("userName")
        val userName: String
    ) : Parcelable
}