package com.example.diaryservice.global.exception

import com.example.diaryservice.global.error.exception.ErrorCode.EXPIRED_TOKEN
import com.example.diaryservice.global.error.exception.MyLogException

class ExpiredTokenException : MyLogException(EXPIRED_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }
}