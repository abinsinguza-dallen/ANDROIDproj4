package com.dallen.workoutlog.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName( "first_name")var firstname:String,
    @SerializedName("last_name")var lastname:String,
    @SerializedName("phone_number") var phonenumber:String,
    var email:String,
    var password:String
)
