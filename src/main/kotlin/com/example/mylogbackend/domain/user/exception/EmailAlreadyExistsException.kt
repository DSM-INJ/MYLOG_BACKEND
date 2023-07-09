package com.example.mylogbackend.domain.user.exception

import com.example.mylogbackend.global.error.exception.ErrorCode
import com.example.mylogbackend.global.error.exception.MyLogException

class EmailAlreadyExistsException : MyLogException(ErrorCode.EMAIL_ALREADY_EXISTS) {
    companion object {
        @JvmField
        val EXCEPTION = EmailAlreadyExistsException()
    }
}