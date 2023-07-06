package com.example.diaryservice.global.exception

import com.example.diaryservice.global.error.exception.ErrorCode
import com.example.diaryservice.global.error.exception.MyLogException

class ValidateTokenException : MyLogException(ErrorCode.VALIDATE_FAIL_TOkEN) {
    companion object {
        @JvmField
        val EXCEPTION = ValidateTokenException()
    }
}