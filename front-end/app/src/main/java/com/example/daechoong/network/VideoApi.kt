package com.example.daechoong.network

import android.provider.MediaStore.Video
import com.example.daechoong.model.VideoResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface VideoApi {
    @GET("/youtube")
    suspend fun getVideos(): VideoResponse
}