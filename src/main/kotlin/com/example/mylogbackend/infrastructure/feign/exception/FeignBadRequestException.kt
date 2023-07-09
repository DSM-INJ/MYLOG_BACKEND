package com.example.mylogbackend.infrastructure.feign.exception

import com.example.mylogbackend.global.error.exception.ErrorCode
import com.example.mylogbackend.global.error.exception.MyLogException

class FeignBadRequestException:MyLogException(ErrorCode.FEIGN_BAD_REQUEST) {
    companion object {
        @JvmField
        val EXCEPTION = FeignBadRequestException()
    }
}