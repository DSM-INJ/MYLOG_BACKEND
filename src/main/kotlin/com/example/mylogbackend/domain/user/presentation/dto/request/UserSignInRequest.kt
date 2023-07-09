package com.example.mylogbackend.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserSignInRequest(
    @field:NotBlank
    var email: String,

    @field:NotBlank
    var password: String
)