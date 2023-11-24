package com.example.daechoong.ui.mycalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daechoong.ApplicationClass.Companion.CAFFEINERESULT
import com.example.daechoong.ApplicationClass.Companion.DAYINFO
import com.example.daechoong.R
import com.example.daechoong.databinding.ActivityDayDetailBinding
import com.example.daechoong.databinding.ActivityMainBinding
import com.example.daechoong.model.Day
import com.example.daechoong.model.History
import com.example.daechoong.ui.adapter.HistoryAdapter
import com.example.daechoong.ui.mycalendar.MyCalendarFragment
import com.example.daechoong.ui.myprofile.LoginFragment
import com.example.daechoong.ui.sleepvideo.SleepVideoFragment

class DayDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDayDetailBinding
    var day: Day = Day(0,"",0,false)
    var histories: List<History> = mutableListOf(
        History(
            dayId = 1,
            caffeineType = "아이스 아메리카노"
        ),
        History(
            dayId = 1,
            caffeineType = "스타벅스 카페라떼"
        ),
        History(
            dayId = 1,
            caffeineType = "스타벅스 바닐라라떼"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDayDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        day = intent.getSerializableExtra(DAYINFO) as Day

        setUi()
        setAdapter()
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
            dateTitle.text = "2023.11.${day.dayName}."
            when (day.caffeineState) {
                0 -> {
                    myCaffeineState.text = "나의 카페인 상태 : 정상"
                    stateImg.setImageResource(R.drawable.green_bean_icon)
                }
                1 -> {
                    myCaffeineState.text = "나의 카페인 상태 : 보통"
                    stateImg.setImageResource(R.drawable.yellow_bean_icon)
                }
                2 -> {
                    myCaffeineState.text = "나의 카페인 상태 : 위험"
                    stateImg.setImageResource(R.drawable.red_bean_icon)
                }
            }
            caffeineAddBtn.setOnClickListener {

            }
        }
    }

    private fun setAdapter() {
        val historyAdapter = HistoryAdapter()

        binding.historyRv.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = historyAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }

        historyAdapter.submitList(histories)
    }
}