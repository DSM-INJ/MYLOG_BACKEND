package com.example.mylogbackend.domain.feed.exception

import com.example.mylogbackend.global.error.exception.ErrorCode.FEED_NOT_FOUND
import com.example.mylogbackend.global.error.exception.MyLogException

class FeedNotFoundException : MyLogException(FEED_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = FeedNotFoundException()
    }
}