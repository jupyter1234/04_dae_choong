package com.example.daechoong.ui.sleepvideo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daechoong.databinding.FragmentMycalendarBinding
import com.example.daechoong.databinding.FragmentMyprofileBinding
import com.example.daechoong.databinding.FragmentSleepvideoBinding
import com.example.daechoong.model.Video
import com.example.daechoong.ui.adapter.VideoAdapter
import com.example.daechoong.viewmodel.VideoViewModel

class SleepVideoFragment: Fragment() {
    lateinit var binding: FragmentSleepvideoBinding
    private val videoViewModel: VideoViewModel by viewModels()

    var videos: List<Video> = mutableListOf(
        Video(
            videoId = 0,
            videoTitle = "영상 제목 1...",
            videoUrl = "iHCCwk3CV70"
        ),
        Video(
            videoId = 1,
            videoTitle = "영상 제목 2...",
            videoUrl = "ga1BdEphF3U"
        ),
        Video(
            videoId = 2,
            videoTitle = "영상 제목 3...",
            videoUrl = "qWDJVbyX25A"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSleepvideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
        setAdapter()
    }

    private fun setUi() {

    }

    private fun setAdapter() {
        val videoAdapter = VideoAdapter()

        binding.videoRc.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = videoAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }

//        videoViewModel.getVideos()
//        videoViewModel.youtube_links.observe(viewLifecycleOwner) {
//            Log.d("ServerResult", it.toString())
//        }
        videoAdapter.submitList(videos)

    }
}