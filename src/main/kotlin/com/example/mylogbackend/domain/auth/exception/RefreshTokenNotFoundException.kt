package com.example.mylogbackend.domain.auth.exception

import com.example.mylogbackend.global.error.exception.ErrorCode
import com.example.mylogbackend.global.error.exception.MyLogException

class RefreshTokenNotFoundException : MyLogException(ErrorCode.REFRESH_TOKEN_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = RefreshTokenNotFoundException()
    }
}