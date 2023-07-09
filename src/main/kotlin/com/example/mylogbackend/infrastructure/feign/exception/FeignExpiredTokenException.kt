package com.example.mylogbackend.infrastructure.feign.exception

import com.example.mylogbackend.global.error.exception.ErrorCode
import com.example.mylogbackend.global.error.exception.MyLogException

class FeignExpiredTokenException : MyLogException(ErrorCode.FEIGN_EXPIRED_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = FeignExpiredTokenException()
    }
}