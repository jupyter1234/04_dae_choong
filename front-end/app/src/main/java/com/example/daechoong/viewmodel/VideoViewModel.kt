package com.example.daechoong.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daechoong.network.RetrofitUtil
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class VideoViewModel : ViewModel() {
    private val _youtube_links = MutableLiveData<List<String>>()
    val youtube_links: LiveData<List<String>>
        get() = _youtube_links

    fun getVideos() {
        viewModelScope.launch {
            _youtube_links.value = RetrofitUtil.videoApi.getVideos().youtube_link
        }
    }
}