package com.example.mylogbackend.domain.feed.service

import com.example.mylogbackend.domain.feed.controller.dto.response.FeedDetailsResponse
import com.example.mylogbackend.domain.feed.facade.FeedFacade
import com.example.mylogbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class FeedDetailsService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {
    @Transactional(readOnly = true)
    fun execute(feedId: UUID): FeedDetailsResponse {
        val feed = feedFacade.getFeed(feedId)

        return FeedDetailsResponse(
            feedId = feed.id,
            title = feed.title,
            content = feed.content,
            createdAt = feed.createdAt,
            sportsTiem = feed.sportsTime,
            sleepTIme = feed.sleepTime,
            whether = feed.whether,
            starScore = feed.starScore,
            image = feed.image
        )
    }
}