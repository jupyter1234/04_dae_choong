package com.example.daechoong.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daechoong.R
import com.example.daechoong.databinding.ActivityMainBinding
import com.example.daechoong.ui.mycalendar.MyCalendarFragment
import com.example.daechoong.ui.myprofile.LoginFragment
import com.example.daechoong.ui.sleepvideo.SleepVideoFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var caffeineResult: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        caffeineResult = intent.getSerializableExtra(CAFFEINERESULT) as Boolean

        setUi()
    }

    private fun setUi() {
        supportFragmentManager.beginTransaction().replace(R.id.framelayout, MyCalendarFragment()).commit()
        binding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.my_calendar -> {
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, MyCalendarFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.sleep_video -> {
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, SleepVideoFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.my_profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, LoginFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }
    }
}