package com.example.daechoong.model

import java.io.Serializable

data class History(
    val dayId: Int,
    val caffeineType: String,
) : Serializable
