package com.example.mylogbackend.domain.feed.domain.repository

import com.example.mylogbackend.domain.feed.domain.Feed
import com.example.mylogbackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeedRepository : JpaRepository<Feed, UUID> {
    fun findAllByUserOrderByCreatedAtDesc(user: User): List<Feed>

    fun findByTitleContainingOrderByCreatedAtDesc(keyword: String): List<Feed>
}