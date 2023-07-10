package com.example.mylogbackend.domain.user.service

import com.example.mylogbackend.domain.user.domain.User
import com.example.mylogbackend.domain.user.domain.repository.UserRepository
import com.example.mylogbackend.domain.user.domain.type.ProviderType.FACEBOOK
import com.example.mylogbackend.domain.user.domain.type.Role.USER
import com.example.mylogbackend.global.security.jwt.JwtProvider
import com.example.mylogbackend.infrastructure.feign.client.FacebookTokenClient
import com.example.mylogbackend.infrastructure.feign.client.FacebookUserInfoClient
import com.example.mylogbackend.infrastructure.feign.dto.response.FacebookUserInfoElement
import com.example.mylogbackend.infrastructure.feign.dto.response.TokenResponse
import com.example.mylogbackend.infrastructure.feign.properties.FacebookFeignProperties
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FacebookOauthService(
    private val facebookTokenClient: FacebookTokenClient,
    private val facebookUserInfoClient: FacebookUserInfoClient,
    private val facebookFeignProperties: FacebookFeignProperties,
    private val userRepository: UserRepository,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder
) {
    companion object {
        val GRANT_TYPE = "authorization_code"
    }

    fun getCode(): TokenResponse {
        val facebookToken: String = "Bearer " + facebookTokenClient.getCode(
            grantType = GRANT_TYPE,
            clientId = facebookFeignProperties.clientId,
            clientSecret = facebookFeignProperties.clientSecret
        ).accessToken

        val userInfo: FacebookUserInfoElement = facebookUserInfoClient.getUserInfo(facebookToken).facebookResponse

        var user: User? = userRepository.findByEmail(userInfo.email)

        if (user == null) {
            user = User(
                id = UUID.randomUUID(),
                email = userInfo.email,
                password = passwordEncoder.encode(userInfo.password),
                name = userInfo.name,
                role = USER,
                providerType = FACEBOOK,
                nickname = userInfo.name,
                profileFileName = null
            )

            userRepository.save(user)
        }

        return jwtProvider.getToken(user.email)
    }
}