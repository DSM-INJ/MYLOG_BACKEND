package com.example.diaryservice.global.exception

import com.example.diaryservice.global.error.exception.ErrorCode.UNEXPECTED_TOKEN
import com.example.diaryservice.global.error.exception.MyLogException

class UnexpectedTokenException : MyLogException(UNEXPECTED_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = UnexpectedTokenException()
    }
}