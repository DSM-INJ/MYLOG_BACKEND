package com.example.mylogbackend.infrastructure.feign.exception

import com.example.mylogbackend.global.error.exception.ErrorCode
import com.example.mylogbackend.global.error.exception.MyLogException

class FeignUnAuthorizedException : MyLogException(ErrorCode.FEIGN_UNAUTHORIZED) {
    companion object {
        @JvmField
        val EXCEPTION = FeignUnAuthorizedException()
    }
}