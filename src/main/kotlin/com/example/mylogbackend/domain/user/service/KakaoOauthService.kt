package com.example.mylogbackend.domain.auth.service

import com.example.mylogbackend.domain.user.domain.User
import com.example.mylogbackend.domain.user.domain.repository.UserRepository
import com.example.mylogbackend.domain.user.domain.type.ProviderType.KAKAO
import com.example.mylogbackend.domain.user.domain.type.Role.USER
import com.example.mylogbackend.global.security.jwt.JwtProvider
import com.example.mylogbackend.infrastructure.feign.client.KakaoTokenClient
import com.example.mylogbackend.infrastructure.feign.client.KakaoUserInfoClient
import com.example.mylogbackend.infrastructure.feign.dto.response.KakaoUserInfoElement
import com.example.mylogbackend.infrastructure.feign.dto.response.TokenResponse
import com.example.mylogbackend.infrastructure.feign.properties.KakaoFeignProperties
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class KakaoOauthService(
    private val kakaoTokenClient: KakaoTokenClient,
    private val kakaoUserInfoClient: KakaoUserInfoClient,
    private val kakaoFeignProperties: KakaoFeignProperties,
    private val userRepository: UserRepository,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder,
) {
    companion object {
        val GRANT_TYPE = "authorization_code"
    }

    fun getCode(): TokenResponse {
        val kakaoToken: String = "Bearer " + kakaoTokenClient.getCode(
            clientId = kakaoFeignProperties.clientId,
            clientSecret = kakaoFeignProperties.clientSecret,
            clientName = kakaoFeignProperties.clientName,
            clientAuthenticationMethod = kakaoFeignProperties.clientAuthenticationMethod,
            authorizationGrantType = GRANT_TYPE,
            redirectUrl = kakaoFeignProperties.redirectUri
        ).accessToken

        val userInfo: KakaoUserInfoElement = kakaoUserInfoClient.getUserInfo(kakaoToken).kakaoResponse

        var user: User? = userRepository.findByEmail(userInfo.accountEmail)

        if (user == null) {
            user = User(
                id = UUID.randomUUID(),
                email = userInfo.accountEmail,
                password = passwordEncoder.encode(userInfo.password),
                name = userInfo.profileNickname,
                nickname = userInfo.profileNickname,
                role = USER,
                providerType = KAKAO,
                profileFileName = null
            )
            userRepository.save(user)
        }

        return jwtProvider.getToken(user.email)
    }
}