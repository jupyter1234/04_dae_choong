package com.example.daechoong.network

import com.example.daechoong.ApplicationClass


class RetrofitUtil {
    companion object {
        val videoApi: VideoApi = ApplicationClass.retrofit.create(VideoApi::class.java)
    }
}