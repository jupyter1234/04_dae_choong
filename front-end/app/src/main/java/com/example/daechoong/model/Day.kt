package com.example.daechoong.model

import java.io.Serializable

data class Day(
    val dayId: Int,
    val dayName: String,
    val caffeineState: Int,
    val visible: Boolean,
) : Serializable
