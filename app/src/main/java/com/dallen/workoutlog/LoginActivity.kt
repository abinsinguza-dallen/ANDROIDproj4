package com.dallen.workoutlog

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var tvSignup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin = findViewById(R.id.btnLogin)
        etPassword = findViewById(R.id.etPassword)
        tilPassword = findViewById(R.id.tilPassword)
        etEmail = findViewById(R.id.etEmail)
        tilEmail = findViewById(R.id.tilEmail)
        tvSignup = findViewById(R.id.tvSignup)
        btnLogin.setOnClickListener { validateLogin() }
//        btnLogin.setOnClickListener { startActivity(intent) }
        btnLogin.setOnClickListener {
            var intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        tvSignup.setOnClickListener {
            var intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateLogin() {
        var error = false
        tilEmail.error = null
        tilPassword.error = null
        var email = etEmail.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.error = "Not valid email address"
            error = true
        }
            var password = etPassword.text.toString()
            if (password.isBlank()) {
                tilPassword.error = "Password is required"
                error = true
            }
            if (error != true) {
//                startActivity(Intent(this, HomeActivity::class.java))


            }

        }
    }

