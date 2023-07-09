package com.example.mylogbackend.domain.feed.service

import com.example.mylogbackend.domain.feed.controller.dto.response.FeedElement
import com.example.mylogbackend.domain.feed.controller.dto.response.FeedListResponse
import com.example.mylogbackend.domain.feed.domain.Feed
import com.example.mylogbackend.domain.feed.domain.repository.FeedRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SearchFeedService(
    private val feedRepository: FeedRepository
) {
    @Transactional(readOnly = true)
    fun execute(keyword: String): FeedListResponse {
        val feedElementList: List<FeedElement> = feedRepository.findByTitleContainingOrderByCreatedAtDesc(keyword)
            .stream()
            .map(this::feedBuilder)
            .toList()

        return FeedListResponse(feedElementList)
    }

    private fun feedBuilder(feed: Feed): FeedElement {
        return FeedElement(
            feedId = feed.id,
            title = feed.title,
            content = feed.content,
            createdAt = feed.createdAt,
            starScore = feed.starScore,
            sleepTIme = feed.sleepTime,
            sportsTiem = feed.sportsTime,
            whether = feed.whether,
            image = feed.image
        )
    }
}