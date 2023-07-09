package com.example.mylogbackend.infrastructure.feign.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)