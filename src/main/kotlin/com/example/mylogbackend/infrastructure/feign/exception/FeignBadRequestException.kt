package com.example.oauth.infrastructure.feign.exception

import com.example.diaryservice.global.error.exception.ErrorCode
import com.example.diaryservice.global.error.exception.MyLogException

class FeignBadRequestException:MyLogException(ErrorCode.FEIGN_BAD_REQUEST) {
    companion object {
        @JvmField
        val EXCEPTION = FeignBadRequestException()
    }
}