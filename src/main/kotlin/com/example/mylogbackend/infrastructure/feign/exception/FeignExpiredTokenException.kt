package com.example.oauth.infrastructure.feign.exception

import com.example.diaryservice.global.error.exception.ErrorCode.FEIGN_EXPIRED_TOKEN
import com.example.diaryservice.global.error.exception.MyLogException


class FeignExpiredTokenException : MyLogException(FEIGN_EXPIRED_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = FeignExpiredTokenException()
    }
}