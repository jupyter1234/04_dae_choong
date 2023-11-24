package com.example.daechoong

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.daechoong.databinding.ActivityCaffeineTestBinding
import com.example.daechoong.databinding.ActivityMainBinding
import com.example.daechoong.ui.mycalendar.MyCalendarFragment
import com.example.daechoong.ui.myprofile.MyProfileFragment
import com.example.daechoong.ui.sleepvideo.SleepVideoFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, MyProfileFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }
    }
}