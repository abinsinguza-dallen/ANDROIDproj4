package com.dallen.workoutlog.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import com.dallen.workoutlog.R
import com.dallen.workoutlog.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
//    lateinit var bnvHome: BottomNavigationView
//    lateinit var fcvHome: FragmentContainerView
    lateinit var sharedPrefs:SharedPreferences
    val exerciseViewModel:ExerciceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNav()

        binding.tvlogout.setOnClickListener {
            sharedPrefs = getSharedPreferences("WORKOULOG_PREFS", MODE_PRIVATE)
            val token=sharedPrefs.getString("TOKEN",)

        }

    }


    fun setupBottomNav() {
        bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Plan -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.Track -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.Profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}