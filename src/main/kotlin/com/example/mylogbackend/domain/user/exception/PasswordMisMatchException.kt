package com.example.mylogbackend.domain.user.exception

import com.example.mylogbackend.global.error.exception.ErrorCode
import com.example.mylogbackend.global.error.exception.MyLogException

class PasswordMisMatchException : MyLogException(ErrorCode.PASSWORD_MISMATCH) {
    companion object {
        @JvmField
        val EXCEPTION = PasswordMisMatchException()
    }
}