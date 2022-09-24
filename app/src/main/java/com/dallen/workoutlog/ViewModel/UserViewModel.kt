package com.dallen.workoutlog.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dallen.workoutlog.Repository.UserRepository
import com.dallen.workoutlog.models.LoginRequest
import com.dallen.workoutlog.models.LoginResponse
import kotlinx.coroutines.launch

class UserViewModel :ViewModel(){
    val UserRepository=UserRepository()
    val loginResponsiveliveData=MutableLiveData<LoginResponse>()
    val errorLiveData=MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=UserRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponsiveliveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}