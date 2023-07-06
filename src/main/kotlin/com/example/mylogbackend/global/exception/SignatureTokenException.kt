package com.example.diaryservice.global.exception

import com.example.diaryservice.global.error.exception.ErrorCode.SIGNATURE_TOKEN
import com.example.diaryservice.global.error.exception.MyLogException

class SignatureTokenException : MyLogException(SIGNATURE_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = SignatureTokenException()
    }
}