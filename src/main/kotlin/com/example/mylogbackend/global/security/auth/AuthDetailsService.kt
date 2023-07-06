package com.example.diaryservice.global.security.auth

import com.example.diaryservice.domain.user.domain.User
import com.example.diaryservice.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class AuthDetailsService(
    private val userFacade: UserFacade
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userFacade.getByName(username)
        return AuthDetails(user = user)
    }
}