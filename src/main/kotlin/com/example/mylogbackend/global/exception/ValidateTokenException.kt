package com.example.mylogbackend.global.exception

import com.example.mylogbackend.global.error.exception.ErrorCode.VALIDATE_FAIL_TOKEN
import com.example.mylogbackend.global.error.exception.MyLogException

class ValidateTokenException : MyLogException(VALIDATE_FAIL_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = ValidateTokenException()
    }
}