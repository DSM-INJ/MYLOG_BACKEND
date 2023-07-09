package com.example.mylogbackend.domain.feed.controller.dto.response

import com.example.mylogbackend.domain.feed.type.StarScore
import com.example.mylogbackend.domain.feed.type.Whether
import java.time.LocalDateTime
import java.util.*

data class FeedElement(
    private val feedId: UUID,
    private val title: String,
    private val content: String,
    private val sportsTiem: Int,
    private val sleepTIme: Int,
    private val starScore: StarScore,
    private val whether: Whether,
    private val image: String,
    private val createdAt: LocalDateTime
)