package com.dallen.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dallen.workoutlog.ApiClient
import com.dallen.workoutlog.ViewModel.UserViewModel
import com.dallen.workoutlog.api.apiInterface
import com.dallen.workoutlog.databinding.ActivityLoginBinding
import com.dallen.workoutlog.models.LoginRequest
import com.dallen.workoutlog.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedprefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedprefs = getSharedPreferences("WORKOULOG_PREFS", MODE_PRIVATE)

        binding.tvSignup.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener { validateLogin()
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponsiveliveData.observe(this, Observer{loginResponse ->
            savelogindetails(loginResponse!!)
            Toast.makeText(baseContext,loginResponse?. message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,HomeActivity::class.java))
            finish()
        })
        userViewModel.errorLiveData.observe(this, Observer{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    fun validateLogin() {

        var email= binding. etEmail.text.toString()
        var password= binding. etPassword.text.toString()
        var error = false

        if (password.isBlank()) {
            binding. tilPassword.error = "Password is required"
            error = true
        }

        if (email.isBlank()) {
           binding. tilEmail.error = "Email is required"
            error = true
        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            binding.tilEmail.error = "Not valid email address"
//            error = true
//        }

            if (!error) {
                binding.pblogin.visibility=View.VISIBLE
                val loginRequest = LoginRequest(email, password)
                userViewModel.loginUser(loginRequest)

            }

        }

//    fun makeLoginRequest(loginRequest: LoginRequest) {
//        var apiClient = ApiClient.buildApiClient(apiInterface::class.java)
//        var request = apiClient.loginUser(loginRequest)
//
//        request.enqueue(object : Callback<LoginResponse> {
//            override fun onResponse( call: Call<LoginResponse>,response: Response<LoginResponse>
//            ) {
//                binding.pblogin.visibility=View .GONE
//
//                if (response.isSuccessful) {
//                    val loginResponse = response.body()
//                    binding.pblogin.visibility=View .GONE
//
//                } else {
//                    val error = response.errorBody()?.string()
//                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//                    logout(loginRequest!!)
//
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                binding.pblogin.visibility=View .GONE
//                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//            }
//
//        })
//    }
    fun savelogindetails(loginResponse: LoginResponse){
        val editor=sharedprefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("USER_ID",loginResponse.profield)
        editor.putString("PROFILE_ID",loginResponse.profield)
        editor.apply()

        
        }
}


//    fun logout(loginRequest: LoginRequest){
//        val editor=logout.edit()
//        editor.putString("EMAIL",loginRequest.email)
//        editor.putString("PASSWORD",loginRequest.password)
//        editor.apply()
//    }


