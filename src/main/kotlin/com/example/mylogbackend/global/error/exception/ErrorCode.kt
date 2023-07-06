package com.example.diaryservice.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    EXPIRED_TOKEN(401, "Expired Token"),
    SIGNATURE_TOKEN(401, "Invalid Signature"),
    VALIDATE_FAIL_TOkEN(401, "Validate Failed Token"),

    USER_ALREADY_EXISTS(409, "Already Exist User"),

    UNEXPECTED_TOKEN(500, "Unexpected Token"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}