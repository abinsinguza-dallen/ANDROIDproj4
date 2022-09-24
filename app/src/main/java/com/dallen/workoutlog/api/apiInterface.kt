package com.dallen.workoutlog.api

import com.dallen.workoutlog.models.LoginRequest
import com.dallen.workoutlog.models.LoginResponse
import com.dallen.workoutlog.models.RegesterResponse
import com.dallen.workoutlog.models.RegisterRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface apiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<RegesterResponse>

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}