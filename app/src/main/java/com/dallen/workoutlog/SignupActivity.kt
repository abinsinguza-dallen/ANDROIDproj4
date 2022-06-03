package com.dallen.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var btnSignUp: Button
    lateinit var tilFirstName: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tilLastName: TextInputLayout
    lateinit var etLastname: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var tilConfirm: TextInputLayout
    lateinit var etConfirm: TextInputEditText
    lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btnSignUp = findViewById(R.id.btnSignUp)
        etFirstName = findViewById(R.id.etFirstName)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        etLastname = findViewById(R.id.etLastname)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etPassword = findViewById(R.id.etPassword)
        tilConfirm = findViewById(R.id.tilConfirm)
        etConfirm = findViewById(R.id.etConfirm)
        tvLogin = findViewById(R.id.tvLogin)
        btnSignUp.setOnClickListener { validateSignup() }
        tvLogin.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun validateSignup() {
        var error = false
        tilFirstName.error=null
        tilLastName.error=null
        tilEmail.error=null
        tilPassword.error=null
        tilConfirm.error=null
        var firstName = etFirstName.text.toString()
        if (firstName.isBlank()) {
            tilFirstName.error = "FirstName is required"
            error = true
        }
        var lastName = etLastname.text.toString()
        if (lastName.isBlank()) {
            tilLastName.error = "Lastname is required"
            error = true
        }
        var Email = etEmail.text.toString()
        if (Email.isBlank()) {
            tilEmail.error = "Password is required"
            error = true
        }
        var password = etPassword.text.toString()
        if (password.isBlank()) {
            tilPassword.error = "Password is required"
            error = true
        }
        var confirm = etConfirm.text.toString()
        if (confirm.isBlank()) {
            tilConfirm.error = "Password is required"
            error = true
        }
        if (error != true) {
        }
    }
}
