package com.example.diaryservice.global.error

import com.example.diaryservice.global.error.exception.MyLogException

class ErrorResponse<T>(
    val status: Int,
    val message: String
) {
    companion object {
        fun of(e: MyLogException): ErrorResponse<Unit> {
            return ErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }
}