package com.example.diaryservice.global.security.jwt

import com.example.diaryservice.domain.auth.domain.RefreshToken
import com.example.diaryservice.domain.auth.domain.repository.RefreshTokenRepository
import com.example.diaryservice.global.exception.ExpiredTokenException
import com.example.diaryservice.global.exception.SignatureTokenException
import com.example.diaryservice.global.exception.UnexpectedTokenException
import com.example.diaryservice.global.exception.ValidateTokenException
import com.example.diaryservice.global.security.auth.AuthDetailsService
import com.example.diaryservice.global.security.jwt.dto.TokenResponse
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.SignatureException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class JwtProvider(
    private val authDetailsService: AuthDetailsService,
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    companion object {
        private const val REFRESH_KEY = "refresh"
        private const val ACCESS_KEY = "access"
    }

    fun getToken(email: String): TokenResponse {
        val accessToken: String = generateToken(email, jwtProperties.accessExp, ACCESS_KEY)
        val refreshToken: String = generateRefreshToken(email)

        return TokenResponse(accessToken, refreshToken)
    }

    fun generateRefreshToken(email: String): String {
        val newRefreshToken: String = generateToken(email, jwtProperties.refreshExp, REFRESH_KEY)
        refreshTokenRepository.save(
            RefreshToken(email, newRefreshToken, jwtProperties.refreshExp)
        )
        return newRefreshToken
    }

    private fun generateToken(email: String, expiration: Long, type: String): String {
        return "Bearer " + Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey).setSubject(email)
            .setHeaderParam("type", type).setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000)).compact()
    }

    fun getAuthentication(token: String?): Authentication? {
        return token?.let {
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))

            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    private fun getTokenSubject(subject: String): String {
        return parseTokenBody(subject).subject
    }

    private fun parseTokenBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey).parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                is SignatureException -> throw SignatureTokenException.EXCEPTION
                is MalformedJwtException -> throw ValidateTokenException.EXCEPTION
                else -> throw UnexpectedTokenException.EXCEPTION
            }
        }
    }
}