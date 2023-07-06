package com.example.diaryservice.domain.auth.domain.repository

import com.example.diaryservice.domain.auth.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {}