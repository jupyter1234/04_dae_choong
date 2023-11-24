package com.example.daechoong.ui.mycalendar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daechoong.ApplicationClass.Companion.CAFFEINERESULT
import com.example.daechoong.ApplicationClass.Companion.DAYINFO
import com.example.daechoong.R
import com.example.daechoong.databinding.FragmentMycalendarBinding
import com.example.daechoong.model.Day
import com.example.daechoong.model.Video
import com.example.daechoong.ui.adapter.DayAdapter
import com.example.daechoong.ui.adapter.VideoAdapter

class MyCalendarFragment: Fragment() {
    lateinit var binding: FragmentMycalendarBinding
    var caffeineResult: Boolean = false
    var days: List<Day> = mutableListOf(
        Day(
            dayId = -1,
            dayName = "-1",
            caffeineState = 0,
            visible = false
        ),
        Day(
            dayId = -1,
            dayName = "-1",
            caffeineState = 0,
            visible = false
        ),
        Day(
            dayId = -1,
            dayName = "-1",
            caffeineState = 0,
            visible = false
        ),
        Day(
            dayId = 1,
            dayName = "1",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 2,
            dayName = "2",
            caffeineState = 1,
            visible = true
        ),
        Day(
            dayId = 3,
            dayName = "3",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 4,
            dayName = "4",
            caffeineState = 2,
            visible = true
        ),
        Day(
            dayId = 5,
            dayName = "5",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 6,
            dayName = "6",
            caffeineState = 0,
            visible = true
        ),Day(
            dayId = 7,
            dayName = "7",
            caffeineState = 2,
            visible = true
        ),
        Day(
            dayId = 8,
            dayName = "8",
            caffeineState = 1,
            visible = true
        ),
        Day(
            dayId = 9,
            dayName = "9",
            caffeineState = 1,
            visible = true
        ),
        Day(
            dayId = 10,
            dayName = "10",
            caffeineState = 2,
            visible = true
        ),
        Day(
            dayId = 11,
            dayName = "11",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 12,
            dayName = "12",
            caffeineState = 1,
            visible = true
        ),
        Day(
            dayId = 13,
            dayName = "13",
            caffeineState = 2,
            visible = true
        ),
        Day(
            dayId = 14,
            dayName = "14",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 15,
            dayName = "15",
            caffeineState = 1,
            visible = true
        ),
        Day(
            dayId = 16,
            dayName = "16",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 17,
            dayName = "17",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 18,
            dayName = "18",
            caffeineState = 1,
            visible = true
        ),
        Day(
            dayId = 19,
            dayName = "19",
            caffeineState = 2,
            visible = true
        ),
        Day(
            dayId = 20,
            dayName = "20",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 21,
            dayName = "21",
            caffeineState = 2,
            visible = true
        ),
        Day(
            dayId = 22,
            dayName = "22",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 23,
            dayName = "23",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 24,
            dayName = "24",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 25,
            dayName = "25",
            caffeineState = 1,
            visible = true
        ),
        Day(
            dayId = 26,
            dayName = "26",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 27,
            dayName = "27",
            caffeineState = 2,
            visible = true
        ),
        Day(
            dayId = 28,
            dayName = "28",
            caffeineState = 0,
            visible = true
        ),
        Day(
            dayId = 29,
            dayName = "29",
            caffeineState = 1,
            visible = true
        ),
        Day(
            dayId = 30,
            dayName = "30",
            caffeineState = 1,
            visible = true
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMycalendarBinding.inflate(inflater, container, false)

        arguments?.let {
            caffeineResult = it.getBoolean(CAFFEINERESULT)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
        setAdapter()
    }

    private fun setUi() {
        if (caffeineResult) {
            binding.titleIcon.setImageResource(R.drawable.addiction_state_icon)
        } else {
            binding.titleIcon.setImageResource(R.drawable.normal_state_icon)
        }
    }

    private fun setAdapter() {
        val dayAdapter = DayAdapter()
        dayAdapter.detailDayListener =
            object : DayAdapter.DetailDayListener {
                override fun onClick(day: Day) {
                    val intent = Intent(activity, DayDetailActivity::class.java)
                    intent.putExtra(DAYINFO, day)
                    startActivity(intent)
                }
            }
        binding.dayRv.apply {
            layoutManager = GridLayoutManager(this.context, 7)
            adapter = dayAdapter
        }

        dayAdapter.submitList(days)
    }
}