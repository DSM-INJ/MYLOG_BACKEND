package com.example.mylogbackend.global.security.jwt

import com.example.mylogbackend.global.security.jwt.JwtProperties
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class JwtResolver(
    private val jwtProperties: JwtProperties
) {
    fun resolveToken(httpServletRequest: HttpServletRequest): String? {
        val bearerToken: String? = httpServletRequest.getHeader(jwtProperties.header)
        return parseToken(bearerToken)
    }

    fun parseToken(token: String?): String? {
        return if (token != null && token.startsWith(jwtProperties.prefix)) {
            return token.replace(jwtProperties.prefix, "")
        } else null
    }
}