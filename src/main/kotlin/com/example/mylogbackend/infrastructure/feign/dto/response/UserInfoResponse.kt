package com.example.mylogbackend.infrastructure.feign.dto.response

data class UserInfoResponse(
    val googleResponse: GoogleUserInfoElement,
    val kakaoResponse: KakaoUserInfoElement,
    val facebookResponse: FacebookUserInfoElement
)