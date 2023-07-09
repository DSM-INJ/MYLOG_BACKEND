package com.example.mylogbackend.domain.feed.service

import com.example.mylogbackend.domain.feed.controller.dto.response.FeedElement
import com.example.mylogbackend.domain.feed.controller.dto.response.FeedListResponse
import com.example.mylogbackend.domain.feed.domain.repository.FeedRepository
import com.example.mylogbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedAllService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): FeedListResponse {
        val user = userFacade.getCurrentUser()

        return FeedListResponse(
            feedRepository.findAllByUserOrderByCreatedAtDesc(user).map {
                FeedElement(
                    feedId = it.id,
                    title = it.title,
                    content = it.content,
                    createdAt = it.createdAt,
                    sportsTiem = it.sportsTime,
                    sleepTIme = it.sleepTime,
                    image = it.image,
                    whether = it.whether,
                    starScore = it.starScore
                )
            }
        )
    }
}