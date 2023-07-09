package com.example.mylogbackend.domain.feed.service

import com.example.mylogbackend.domain.feed.controller.dto.request.CreateFeedRequset
import com.example.mylogbackend.domain.feed.domain.Feed
import com.example.mylogbackend.domain.feed.domain.repository.FeedRepository
import com.example.mylogbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class CreateFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: CreateFeedRequset) {

        val user = userFacade.getCurrentUser()

        feedRepository.save(
            Feed(
                id = UUID.randomUUID(),
                title = request.title,
                content = request.content,
                image = request.image!!,
                starScore = request.starScore,
                sportsTime = request.sportTime,
                sleepTime = request.sleepTime,
                user = user,
                createdAt = LocalDateTime.now(),
                whether = request.whether
            )
        )
    }
}