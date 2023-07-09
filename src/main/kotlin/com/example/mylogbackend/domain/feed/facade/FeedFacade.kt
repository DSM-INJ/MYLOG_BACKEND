package com.example.mylogbackend.domain.feed.facade

import com.example.mylogbackend.domain.feed.domain.Feed
import com.example.mylogbackend.domain.feed.domain.repository.FeedRepository
import com.example.mylogbackend.domain.feed.exception.FeedNotFoundException
import org.springframework.stereotype.Component
import java.util.*

@Component
class FeedFacade(
    private val feedRepository: FeedRepository
) {

    fun getFeed(id: UUID): Feed {
        return feedRepository.findById(id)
            .orElseThrow { FeedNotFoundException.EXCEPTION }
    }
}