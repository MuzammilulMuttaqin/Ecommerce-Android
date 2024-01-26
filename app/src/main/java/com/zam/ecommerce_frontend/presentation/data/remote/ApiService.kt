package com.zam.ecommerce_frontend.presentation.data.remote

import com.zam.ecommerce_frontend.presentation.data.model.request.LoginRequest
import com.zam.ecommerce_frontend.presentation.data.model.request.RefreshTokenRequest
import com.zam.ecommerce_frontend.presentation.data.model.request.RegisterRequest
import com.zam.ecommerce_frontend.presentation.data.model.response.LoginResponse
import com.zam.ecommerce_frontend.presentation.data.model.response.ProfileResponse
import com.zam.ecommerce_frontend.presentation.data.model.response.RefreshTokenResponse
import com.zam.ecommerce_frontend.presentation.data.model.response.RegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @POST("register")
    suspend fun fetchRegister(@Body request: RegisterRequest): RegisterResponse

    @POST("login")
    suspend fun fetchRegister(@Body request: LoginRequest): LoginResponse

    @POST("refresh")
    suspend fun fetchRefresh(@Body request: RefreshTokenRequest) : RefreshTokenResponse

    @POST("profile")
    @Multipart
    suspend fun fetchProfile(
        @Part username: RequestBody,
        @Part userImage: MultipartBody.Part
    ) : ProfileResponse
}