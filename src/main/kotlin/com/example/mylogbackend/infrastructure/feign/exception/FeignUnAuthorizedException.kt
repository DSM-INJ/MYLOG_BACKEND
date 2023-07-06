package com.example.oauth.infrastructure.feign.exception

import com.example.diaryservice.global.error.exception.ErrorCode
import com.example.diaryservice.global.error.exception.MyLogException

class FeignUnAuthorizedException : MyLogException(ErrorCode.FEIGN_UNAUTHORIZED) {
    companion object {
        @JvmField
        val EXCEPTION = FeignUnAuthorizedException()
    }
}