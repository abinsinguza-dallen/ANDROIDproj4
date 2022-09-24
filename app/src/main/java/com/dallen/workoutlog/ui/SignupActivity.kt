package com.dallen.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.dallen.workoutlog.ApiClient
import com.dallen.workoutlog.api.apiInterface
import com.dallen.workoutlog.databinding.ActivitySignupBinding
import com.dallen.workoutlog.models.RegesterResponse
import com.dallen.workoutlog.models.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()

        binding.tvLogin.setOnClickListener { validation()}

        binding.btnSignUp.setOnClickListener {
            validation()

        }
    }
    fun castViews(){
        binding.btnSignUp.setOnClickListener { validation() }
        binding.btnSignUp.setOnClickListener {
            val intent=Intent(this, LoginActivity:: class.java)
            startActivity(intent)
        }
    }

        fun validation() {
            var error = false
            binding.tilEmail.error = null
            binding.tilPassword.error = null
            binding.tilFirstname.error = null
            binding.tilLastname.error = null

            var firstName = binding.etFirstName.text.toString()
            if (firstName.isBlank()) {
                binding.tilFirstname.error = "FirstName is required"
                error=true
            }
            var lastName = binding.etLastname.text.toString()
            if (lastName.isBlank()) {
                binding.tilLastname.error = "Lastname is required"
                error = true
            }
            var Email = binding.etEmail.text.toString()
            if (Email.isBlank()) {
                binding.tilEmail.error = "Password is required"
                error= true
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                binding.tilEmail.error = "Not valid email address"
                error = true
            }
            var password = binding.etPassword.text.toString()
            if (password.isBlank()) {
                binding.tilPassword.error = "Password is required"
                error = true
            }
            var confirm = binding.etConfirm.text.toString()
            if (confirm.isBlank()) {
                binding.tilConfirm.error = "Password is required"
                error = true
            }
            var Confirm = binding.etConfirm.text.toString()
            if (Confirm != password) {
                binding.tilConfirm.error = "password does not match"
                error = true

            }
            if (error != true) {
                val registerRequest=RegisterRequest(firstName,lastName,password,Confirm,Email)
                makeRegeister(registerRequest)
                startActivity(Intent(this,LoginActivity::class.java))

            }

        }
    fun makeRegeister(registerRequest: RegisterRequest){
        var  apiClient= ApiClient.buildApiClient(apiInterface::class.java)
        val request= apiClient.registerUser(registerRequest)

        request.enqueue(object : Callback<RegesterResponse> {
            override fun onResponse(
                call: Call<RegesterResponse>, response: Response<RegesterResponse>
            ) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message, Toast.LENGTH_LONG).show()

                }
                else {
                    val error=response.errorBody()?.string()
                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//                    startActivity(Intent(baseContext,LoginActivity::class.java))

                }
            }

            override fun onFailure(call: Call<RegesterResponse>, t: Throwable) {
                Toast .makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

}


