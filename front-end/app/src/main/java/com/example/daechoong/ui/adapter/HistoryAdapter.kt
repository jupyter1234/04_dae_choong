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
import com.example.daechoong.databinding.ItemHisotryBinding
import com.example.daechoong.databinding.ItemVideoBinding
import com.example.daechoong.model.Day
import com.example.daechoong.model.History
import com.example.daechoong.model.Video
import com.example.daechoong.ui.mycalendar.DayDetailActivity
import com.example.daechoong.ui.sleepvideo.SleepVideoFragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class HistoryAdapter : ListAdapter<History, HistoryAdapter.HistoryViewHolder>(
    HistoryAllDiffCallback()
) {
    private lateinit var binding: ItemHisotryBinding

    inner class HistoryViewHolder(private val binding: ItemHisotryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBind(history: History) {
            binding.apply {
                caffeineType.text = history.caffeineType
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        binding = ItemHisotryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }
}

class HistoryAllDiffCallback : DiffUtil.ItemCallback<History>() {
    override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
        return oldItem.dayId == newItem.dayId
    }

    override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
        return oldItem == newItem
    }
}