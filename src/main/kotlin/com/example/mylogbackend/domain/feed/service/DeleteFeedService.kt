package com.example.mylogbackend.domain.feed.service

import com.example.mylogbackend.domain.feed.domain.repository.FeedRepository
import com.example.mylogbackend.domain.feed.facade.FeedFacade
import com.example.mylogbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DeleteFeedService(
    private val feedRepository: FeedRepository,
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(feedId:UUID) {
        val feed = feedFacade.getFeed(feedId)

        feedRepository.delete(feed)
    }
}