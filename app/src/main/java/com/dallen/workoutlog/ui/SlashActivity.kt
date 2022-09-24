package com.dallen.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SlashActivity : AppCompatActivity() {
    lateinit var sharedprefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedprefs=getSharedPreferences("ORKOULOG_PREFS", MODE_PRIVATE)
        val accesstoken=sharedprefs.getString("ACCESS_TOKEN","")
        if (accesstoken!!.isBlank()){
            startActivity(Intent(this, LoginActivity::class.java))


        }
        else{        startActivity(Intent(this, HomeActivity::class.java))

        }}}
