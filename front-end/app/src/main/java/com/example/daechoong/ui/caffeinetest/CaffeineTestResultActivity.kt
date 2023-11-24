package com.example.daechoong.ui.caffeinetest

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daechoong.ApplicationClass.Companion.CAFFEINERESULT
import com.example.daechoong.ui.MainActivity
import com.example.daechoong.R
import com.example.daechoong.databinding.ActivityCaffeineTestResultBinding

class CaffeineTestResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityCaffeineTestResultBinding
    var caffeineResult: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaffeineTestResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        caffeineResult = intent.getSerializableExtra(CAFFEINERESULT) as Boolean

        setUi()
    }

    private fun setUi() {
        var intent = Intent(this, MainActivity::class.java)

        if (caffeineResult) {
            binding.resultIcon.setImageResource(R.drawable.caffein_prohibit_icon)
            binding.resultState.text = "중독"
            binding.resultState.setTextColor(Color.parseColor("#FF0000"))
            intent.putExtra(CAFFEINERESULT, true)
        } else {
            binding.resultIcon.setImageResource(R.drawable.coffee_icon)
            binding.resultState.text = "정상"
            binding.resultState.setTextColor(Color.parseColor("#79C257"))
            intent.putExtra(CAFFEINERESULT, false)
        }
        binding.startBtn.setOnClickListener {
            startActivity(intent)
            finish()
        }
        binding.endBtn.setOnClickListener {
            finish()
        }
    }
}