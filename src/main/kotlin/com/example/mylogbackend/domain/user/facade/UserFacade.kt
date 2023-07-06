package com.example.diaryservice.domain.user.facade

import com.example.diaryservice.domain.user.domain.User
import com.example.diaryservice.domain.user.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun checkUserExist(email: String): Boolean {
        return userRepository.existsByEmail(email)
    }

    fun getByName(username: String): User {
        return userRepository.findByName(username)
    }
}