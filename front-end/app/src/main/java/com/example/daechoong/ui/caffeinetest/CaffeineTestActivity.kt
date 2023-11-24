package com.example.daechoong.ui.caffeinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daechoong.databinding.ActivityCaffeineTestBinding

class CaffeineTestActivity : AppCompatActivity() {
    lateinit var binding: ActivityCaffeineTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaffeineTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    private fun setUi() {

    }
}