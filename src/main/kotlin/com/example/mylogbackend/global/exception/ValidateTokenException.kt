package com.example.diaryservice.global.exception

import com.example.diaryservice.global.error.exception.ErrorCode.VALIDATE_FAIL_TOkEN
import com.example.diaryservice.global.error.exception.MyLogException

class ValidateTokenException : MyLogException(VALIDATE_FAIL_TOkEN) {
    companion object {
        @JvmField
        val EXCEPTION = ValidateTokenException()
    }
}