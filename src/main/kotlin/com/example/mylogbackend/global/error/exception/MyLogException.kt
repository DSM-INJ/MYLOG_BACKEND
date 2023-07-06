package com.example.diaryservice.global.error.exception

open class MyLogException(
    private val errorCode: ErrorCode
) : RuntimeException() {
    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message

    override fun fillInStackTrace(): Throwable {
        return this
    }
}