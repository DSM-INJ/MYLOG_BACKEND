package com.example.mylogbackend.infrastructure.feign.exception

import com.example.mylogbackend.global.error.exception.MyLogException
import com.example.mylogbackend.global.error.exception.ErrorCode

class FeignForbiddenException : MyLogException(ErrorCode.FEIGN_FORBIDDEN) {
    companion object {
        @JvmField
        val EXCEPTION = FeignForbiddenException()
    }
}