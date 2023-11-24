package com.example.daechoong.model

import java.io.Serializable

data class Video(
    val videoId: Int,
    val videoUrl: String,
    val videoTitle: String,
) : Serializable
