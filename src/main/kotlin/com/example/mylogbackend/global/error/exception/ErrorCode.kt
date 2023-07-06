package com.example.diaryservice.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),
    EXPIRED_TOKEN(401, "Expired Token"),
    SIGNATURE_TOKEN(401, "Invalid Signature"),
    VALIDATE_FAIL_TOkEN(401, "Validate Failed Token"),
    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),

    USER_NOT_FOUND(404, "User Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden"),

    EMAIL_ALREADY_EXISTS(409, "Email Already Exists"),

    FEIGN_EXPIRED_TOKEN(419, "Feign Expired Token"),

    UNEXPECTED_TOKEN(500, "Unexpected Token Exception"),
    INTENAL_SERVER_ERROR(500, "Internal Server Error");
}