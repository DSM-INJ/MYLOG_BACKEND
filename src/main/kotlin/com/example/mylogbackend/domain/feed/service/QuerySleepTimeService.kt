package com.example.mylogbackend.domain.feed.service

import com.example.mylogbackend.domain.feed.controller.dto.response.QuerySleepTimeResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QuerySleepTimeService {
    @Transactional(readOnly = true)
    fun execute() : QuerySleepTimeResponse {
        return QuerySleepTimeResponse(
            Random().nextInt(3,10),
            Random().nextInt(3,10),
            Random().nextInt(3,10),
            Random().nextInt(3,10),
            Random().nextInt(3,10),
            Random().nextInt(3,10),
            Random().nextInt(3,10)
        )
    }
}