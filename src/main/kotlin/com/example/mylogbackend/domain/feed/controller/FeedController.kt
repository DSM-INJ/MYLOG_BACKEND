package com.example.mylogbackend.domain.feed.controller

import com.example.mylogbackend.domain.feed.controller.dto.request.CreateFeedRequset
import com.example.mylogbackend.domain.feed.controller.dto.request.UpdateFeedRequest
import com.example.mylogbackend.domain.feed.controller.dto.response.FeedDetailsResponse
import com.example.mylogbackend.domain.feed.controller.dto.response.FeedListResponse
import com.example.mylogbackend.domain.feed.controller.dto.response.QuerySatisfactionResponse
import com.example.mylogbackend.domain.feed.controller.dto.response.QuerySleepTimeResponse
import com.example.mylogbackend.domain.feed.service.CreateFeedService
import com.example.mylogbackend.domain.feed.service.DeleteFeedService
import com.example.mylogbackend.domain.feed.service.FeedDetailsService
import com.example.mylogbackend.domain.feed.service.QueryFeedAllService
import com.example.mylogbackend.domain.feed.service.QuerySatisfactionService
import com.example.mylogbackend.domain.feed.service.QuerySleepTimeService
import com.example.mylogbackend.domain.feed.service.SearchFeedService
import com.example.mylogbackend.domain.feed.service.UpdateFeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RequestMapping("/feed")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val updateFeedService: UpdateFeedService,
    private val deleteFeedService: DeleteFeedService,
    private val feedDetailsService: FeedDetailsService,
    private val queryFeedAllService: QueryFeedAllService,
    private val searchFeedService: SearchFeedService,
    private val querySleepTimeService: QuerySleepTimeService,
    private val querySatisfactionService: QuerySatisfactionService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequset) {
        createFeedService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    fun modifyFeed(@PathVariable("feed-id") feedId: UUID, @RequestBody @Valid request: UpdateFeedRequest) {
        updateFeedService.execute(feedId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun deleteFeed(@PathVariable("feed-id") feedId: UUID) {
        deleteFeedService.execute(feedId)
    }

    @GetMapping("/{feed-id}")
    fun feedDetails(@PathVariable("feed-id") feedId: UUID): FeedDetailsResponse {
        return feedDetailsService.execute(feedId)
    }

    @GetMapping("/list")
    fun feedList(): FeedListResponse {
        return queryFeedAllService.execute()
    }

    @GetMapping("/search/{keyword}")
    fun searchFeed(@PathVariable("keyword") keyword: String): FeedListResponse {
        return searchFeedService.execute(keyword)
    }

    @GetMapping("/sleeptime")
    fun querySleepTime(): QuerySleepTimeResponse {
        return querySleepTimeService.execute()
    }

    @GetMapping("/satisfaction")
    fun querySatisfaction(): QuerySatisfactionResponse {
        return querySatisfactionService.execute()
    }
}