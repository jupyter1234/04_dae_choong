package com.example.daechoong.ui.adapter

import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.daechoong.R
import com.example.daechoong.databinding.ItemDayBinding
import com.example.daechoong.databinding.ItemVideoBinding
import com.example.daechoong.model.Day
import com.example.daechoong.model.Video
import com.example.daechoong.ui.mycalendar.DayDetailActivity
import com.example.daechoong.ui.sleepvideo.SleepVideoFragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DayAdapter : ListAdapter<Day, DayAdapter.DayViewHolder>(
    DayAllDiffCallback()
) {
    private lateinit var binding: ItemDayBinding

    inner class DayViewHolder(private val binding: ItemDayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBind(day: Day) {
            if (day.visible) {
                binding.apply {
                    dayName.text = day.dayName
                    when (day.caffeineState) {
                        0 -> caffeineState.setImageResource(R.drawable.green_bean_icon)
                        1 -> caffeineState.setImageResource(R.drawable.yellow_bean_icon)
                        2 -> caffeineState.setImageResource(R.drawable.red_bean_icon)
                    }
                    root.setOnClickListener {
                        detailDayListener.onClick(day = day)
                    }
                }
            } else {
                binding.root.visibility = View.INVISIBLE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        binding = ItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailDayListener {
        fun onClick(day: Day)
    }

    lateinit var detailDayListener: DetailDayListener
}

class DayAllDiffCallback : DiffUtil.ItemCallback<Day>() {
    override fun areItemsTheSame(oldItem: Day, newItem: Day): Boolean {
        return oldItem.dayId == newItem.dayId
    }

    override fun areContentsTheSame(oldItem: Day, newItem: Day): Boolean {
        return oldItem == newItem
    }
}