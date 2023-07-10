package com.example.mylogbackend.domain.user.presentation

import com.example.mylogbackend.domain.user.service.FacebookOauthService
import com.example.mylogbackend.infrastructure.feign.dto.response.TokenResponse
import com.example.mylogbackend.domain.user.service.GoogleOauthService
import com.example.mylogbackend.domain.user.service.KakaoOauthService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthController(
    private val googleOauthService: GoogleOauthService,
    private val kakaoOauthService: KakaoOauthService,
    private val facebookOauthService: FacebookOauthService
) {
    @GetMapping("/google")
    fun getGoogleCode(): TokenResponse {
        return googleOauthService.getCode()
    }

    @GetMapping("/kakao")
    fun getKakaoCode(): TokenResponse {
        return kakaoOauthService.getCode()
    }

    @GetMapping("/facebook")
    fun getFacebookCode(): TokenResponse {
        return facebookOauthService.getCode()
    }
}