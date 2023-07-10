package com.example.mylogbackend.domain.user.service

import com.example.mylogbackend.domain.user.domain.User
import com.example.mylogbackend.domain.user.domain.repository.UserRepository
import com.example.mylogbackend.domain.user.domain.type.ProviderType.GOOGLE
import com.example.mylogbackend.domain.user.domain.type.Role.USER
import com.example.mylogbackend.global.security.jwt.JwtProvider
import com.example.mylogbackend.infrastructure.feign.client.GoogleTokenClient
import com.example.mylogbackend.infrastructure.feign.client.GoogleUserInfoClient
import com.example.mylogbackend.infrastructure.feign.dto.response.GoogleUserInfoElement
import com.example.mylogbackend.infrastructure.feign.dto.response.TokenResponse
import com.example.mylogbackend.infrastructure.feign.properties.GoogleFeignProperties
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GoogleOauthService(
    private val googleTokenClient: GoogleTokenClient,
    private val googleUserInfoClient: GoogleUserInfoClient,
    private val googleFeignProperties: GoogleFeignProperties,
    private val userRepository: UserRepository,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder
) {
    companion object {
        const val GRANT_TYPE = "authorization_code"
    }

    fun getCode(): TokenResponse {
        val googleToken: String = "Bearer " + googleTokenClient.getCode(
            grantType = GRANT_TYPE,
            clientId = googleFeignProperties.clientId,
            clientSecret = googleFeignProperties.clientSecret
        ).accessToken

        val userInfo: GoogleUserInfoElement = googleUserInfoClient.getUserInfo(googleToken).googleResponse

        var user: User? = userRepository.findByEmail(userInfo.email)

        if (user == null) {
            user = User(
                id = UUID.randomUUID(),
                email = userInfo.email,
                password = passwordEncoder.encode(userInfo.password),
                name = userInfo.name,
                role = USER,
                providerType = GOOGLE,
                nickname = userInfo.name,
                profileFileName = null
            )
            userRepository.save(user)
        }

        return jwtProvider.getToken(user.email)
    }
}