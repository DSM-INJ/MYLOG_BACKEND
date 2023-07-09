package com.example.mylogbackend.domain.feed.controller.dto.response

import com.example.mylogbackend.domain.feed.type.StarScore
import com.example.mylogbackend.domain.feed.type.Whether
import java.time.LocalDateTime
import java.util.*

data class FeedDetailsResponse(
    val feedId: UUID,
    val title: String,
    val content: String,
    val sportsTiem: Int,
    val sleepTIme: Int,
    val starScore: StarScore,
    val whether: Whether,
    val image: String,
    val createdAt: LocalDateTime
)