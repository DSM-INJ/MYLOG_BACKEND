package com.example.mylogbackend.global.exception

import com.example.mylogbackend.global.error.exception.ErrorCode
import com.example.mylogbackend.global.error.exception.MyLogException

class SignatureTokenException : MyLogException(ErrorCode.JWT_SIGNATURE) {
    companion object {
        @JvmField
        val EXCEPTION = SignatureTokenException()
    }
}