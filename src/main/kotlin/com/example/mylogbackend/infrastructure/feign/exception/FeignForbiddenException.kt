package com.example.oauth.infrastructure.feign.exception

import com.example.diaryservice.global.error.exception.ErrorCode.FEIGN_FORBIDDEN
import com.example.diaryservice.global.error.exception.MyLogException

class FeignForbiddenException : MyLogException(FEIGN_FORBIDDEN) {
    companion object {
        @JvmField
        val EXCEPTION = FeignForbiddenException()
    }
}