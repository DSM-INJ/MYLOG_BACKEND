package com.example.mylogbackend.domain.user.facade

import com.example.mylogbackend.domain.user.domain.User
import com.example.mylogbackend.domain.user.domain.repository.UserRepository
import com.example.mylogbackend.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        val email: String = SecurityContextHolder.getContext().authentication.name

        return getByEmail(email)
    }

    fun checkUserExist(email: String): Boolean {
        return userRepository.existsByEmail(email)
    }

    fun getByEmail(email: String): User {
        return userRepository.findByEmail(email) ?: throw UserNotFoundException.EXCEPTION
    }
}