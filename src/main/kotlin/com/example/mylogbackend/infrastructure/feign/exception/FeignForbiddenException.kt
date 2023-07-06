package com.example.oauth.infrastructure.feign.exception

import com.example.diaryservice.global.error.exception.ErrorCode
import com.example.diaryservice.global.error.exception.MyLogException

class FeignForbiddenException : MyLogException(ErrorCode.FEIGN_FORBIDDEN) {
    companion object {
        @JvmField
        val EXCEPTION = FeignForbiddenException()
    }
}