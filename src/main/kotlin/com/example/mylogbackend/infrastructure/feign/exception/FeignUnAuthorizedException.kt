package com.example.oauth.infrastructure.feign.exception

import com.example.diaryservice.global.error.exception.ErrorCode.FEIGN_UNAUTHORIZED
import com.example.diaryservice.global.error.exception.MyLogException

class FeignUnAuthorizedException : MyLogException(FEIGN_UNAUTHORIZED) {
    companion object {
        @JvmField
        val EXCEPTION = FeignUnAuthorizedException()
    }
}