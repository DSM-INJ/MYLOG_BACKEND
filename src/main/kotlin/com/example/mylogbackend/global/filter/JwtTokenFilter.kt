package com.example.oauth.global.filter

import com.example.mylogbackend.global.security.jwt.JwtProvider
import com.example.mylogbackend.global.security.jwt.JwtResolver
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenFilter(
    private val jwtProvider: JwtProvider,
    private val jwtResolver: JwtResolver
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val bearer: String? = jwtResolver.resolveToken(request)
        if (bearer != null) {
            val authentication: Authentication? = jwtProvider.getAuthentication(bearer)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }
}