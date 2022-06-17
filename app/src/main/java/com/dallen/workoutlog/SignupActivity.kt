package com.dallen.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.dallen.workoutlog.databinding.ActivityLoginBinding
import com.dallen.workoutlog.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogin.setOnClickListener { validation()}
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
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
            }

        }}


