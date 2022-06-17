package com.dallen.workoutlog

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dallen.workoutlog.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { validateLogin() }
        binding.btnLogin.setOnClickListener {
            var intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
//        binding.tvSignup.setOnClickListener {
//            var intent=Intent(this,SignupActivity::class.java)
//            startActivity(intent)
//        }
    }
    fun validateLogin() {
        var error = false
       binding. tilEmail.error = null
        binding.tilPassword.error = null
        var email = binding.etEmail.text.toString()
        if (email.isBlank()) {
           binding. tilEmail.error = "Email is required"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Not valid email address"
            error = true
        }
            var password = binding.etPassword.text.toString()
            if (password.isBlank()) {
               binding. tilPassword.error = "Password is required"
                error = true
            }
            if (error != true) {
//                startActivity(Intent(this, HomeActivity::class.java))


            }

        }
    }

