package com.example.mylogbackend.domain.feed.service

import com.example.mylogbackend.domain.feed.controller.dto.request.UpdateFeedRequest
import com.example.mylogbackend.domain.feed.facade.FeedFacade
import com.example.mylogbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UpdateFeedService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {
    @Transactional
    fun execute(feedId: UUID, request: UpdateFeedRequest) {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getFeed(feedId)

        feed.modifyFeed(
            request.title,
            request.content,
            request.starScore,
            request.whether,
            request.sleepTime,
            request.sportTime,
            request.image!!
        )
    }
}