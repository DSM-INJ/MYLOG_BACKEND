package com.example.diaryservice.global.exception

import com.example.diaryservice.global.error.exception.ErrorCode
import com.example.diaryservice.global.error.exception.MyLogException

object InternalServerError : MyLogException(ErrorCode.INTENAL_SERVER_ERROR) {
    val EXCEPTION = InternalServerError
}