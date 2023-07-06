package com.example.oauth.infrastructure.feign.exception

import com.example.diaryservice.global.error.exception.ErrorCode.FEIGN_BAD_REQUEST
import com.example.diaryservice.global.error.exception.MyLogException

class FeignBadRequestException:MyLogException(FEIGN_BAD_REQUEST) {
    companion object {
        @JvmField
        val EXCEPTION = FeignBadRequestException()
    }
}