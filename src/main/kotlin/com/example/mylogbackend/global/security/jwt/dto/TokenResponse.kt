package com.example.diaryservice.global.security.jwt.dto

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)