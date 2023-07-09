package com.example.mylogbackend.domain.feed.service

import com.example.mylogbackend.domain.feed.controller.dto.response.QuerySatisfactionResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QuerySatisfactionService {
    @Transactional(readOnly = true)
    fun execute(): QuerySatisfactionResponse {
        return QuerySatisfactionResponse(Random().nextInt(30, 100))
    }
}