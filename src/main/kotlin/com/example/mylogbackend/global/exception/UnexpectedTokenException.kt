package com.example.mylogbackend.global.exception

import com.example.mylogbackend.global.error.exception.MyLogException
import com.example.mylogbackend.global.error.exception.ErrorCode

class UnexpectedTokenException : MyLogException(ErrorCode.UNEXPECTED_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = UnexpectedTokenException()
    }
}