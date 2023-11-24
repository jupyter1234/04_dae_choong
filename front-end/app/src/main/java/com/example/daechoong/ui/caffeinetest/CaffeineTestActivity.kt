package com.example.daechoong.ui.caffeinetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daechoong.ApplicationClass.Companion.CAFFEINERESULT
import com.example.daechoong.databinding.ActivityCaffeineTestBinding

class CaffeineTestActivity : AppCompatActivity() {
    lateinit var binding: ActivityCaffeineTestBinding
    var stepNum = 1
    var yesNum = 0
    var noNum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaffeineTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    private fun setUi() {
        binding.stepState.text = "[Step. 10 / ${stepNum}]"
        binding.yesBtn.setOnClickListener {
            if (stepNum <= 10) {
                yesNum++
                stepNum++
                checkStep()
            }
        }
        binding.noBtn.setOnClickListener {
            if (stepNum <= 10) {
                noNum++
                stepNum++
                checkStep()
            }
        }

    }

    private fun checkStep() {
        binding.stepState.text = "[Step. 10 / ${stepNum}]"
        when (stepNum) {
            1 -> {
                binding.questionNum.text = "첫 번째 질문"
                binding.questionContent.text = "매일 3잔 이상의 커피를 마신다"
            }
            2 -> {
                binding.questionNum.text = "두 번째 질문"
                binding.questionContent.text = "에너지 음료를 매일 섭취하고 있다"
            }
            3 -> {
                binding.questionNum.text = "세 번째 질문"
                binding.questionContent.text = "커피나 카페인 음료를 즐길 목적보다 잠을 깨기 위해서 마신다"
            }
            4 -> {
                binding.questionNum.text = "네 번째 질문"
                binding.questionContent.text = "카페인 음료를 마시지 않으면 피로해서 견딜 수가 없다"
            }
            5 -> {
                binding.questionNum.text = "다섯 번째 질문"
                binding.questionContent.text = "커피나 카페인 음료를 끊으려고 시도해 본 적이 있다"
            }
            6 -> {
                binding.questionNum.text = "여섯 번째 질문"
                binding.questionContent.text = "장시간 카페인을 섭취하지 않으면 졸음이 몰려온다"
            }
            7 -> {
                binding.questionNum.text = "일곱 번째 질문"
                binding.questionContent.text = "카페인을 섭취하지 않으면 두통이 온다\n(반대로 카페인을 섭취하면\n두통이 줄어든다)"
            }
            8 -> {
                binding.questionNum.text = "여덟 번째 질문"
                binding.questionContent.text = "커피나 카페인 음료를 마시지 않으면 일에 집중할 수 없다"
            }
            9 -> {
                binding.questionNum.text = "아홉 번째 질문"
                binding.questionContent.text = "카페인을 섭취하지 않으면 불안감, 초조함이 든다"
            }
            10 -> {
                binding.questionNum.text = "열 번째 질문"
                binding.questionContent.text = "카페인을 섭취하지 않으면 활력이 떨어지고 무기력감이 든다"
            }
        }

        if (stepNum == 10) {
            var intent = Intent(this, CaffeineTestResultActivity::class.java)
            if (yesNum >= 5) {
                intent.putExtra(CAFFEINERESULT, true)
            } else {
                intent.putExtra(CAFFEINERESULT, false)
            }
            startActivity(intent)
            finish()
        }
    }
}