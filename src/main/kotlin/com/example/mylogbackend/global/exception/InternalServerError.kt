package com.example.mylogbackend.global.exception

import com.example.mylogbackend.global.error.exception.ErrorCode
import com.example.mylogbackend.global.error.exception.MyLogException

object InternalServerError : MyLogException(ErrorCode.INTENAL_SERVER_ERROR) {
    val EXCEPTION = InternalServerError
}