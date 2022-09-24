package com.dallen.workoutlog.Repository

import com.dallen.workoutlog.ApiClient
import com.dallen.workoutlog.api.apiInterface
import com.dallen.workoutlog.models.LoginRequest
import com.dallen.workoutlog.models.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(apiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest):
            Response<LoginResponse> =
        withContext(Dispatchers.IO) {
            val response = apiClient.login(loginRequest)
            return@withContext response
        }
}
