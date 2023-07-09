package com.example.mylogbackend.domain.feed.controller.dto.response

data class QuerySleepTimeResponse(
    val sunday: Int,
    val monday: Int,
    val tuesday: Int,
    val wednesday: Int,
    val thursday: Int,
    val friday: Int,
    val saturday: Int
)