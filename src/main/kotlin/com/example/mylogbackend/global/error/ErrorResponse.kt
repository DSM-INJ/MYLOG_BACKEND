package com.example.mylogbackend.global.error

import com.example.mylogbackend.global.error.exception.MyLogException

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