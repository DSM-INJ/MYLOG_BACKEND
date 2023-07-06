package com.example.diaryservice.global.exception

import com.example.diaryservice.global.error.exception.ErrorCode.INTERNAL_SERVER_ERROR
import com.example.diaryservice.global.error.exception.MyLogException

object InternalServerError : MyLogException(INTERNAL_SERVER_ERROR) {
    val EXCEPTION = InternalServerError
}