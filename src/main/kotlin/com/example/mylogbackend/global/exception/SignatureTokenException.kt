package com.example.diaryservice.global.exception

import com.example.diaryservice.global.error.exception.ErrorCode
import com.example.diaryservice.global.error.exception.MyLogException

class SignatureTokenException : MyLogException(ErrorCode.SIGNATURE_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = SignatureTokenException()
    }
}