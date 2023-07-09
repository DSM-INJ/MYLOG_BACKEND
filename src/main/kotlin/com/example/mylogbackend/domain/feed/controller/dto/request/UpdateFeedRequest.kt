package com.example.mylogbackend.domain.feed.controller.dto.request

import com.example.mylogbackend.domain.feed.type.StarScore
import com.example.mylogbackend.domain.feed.type.Whether
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateFeedRequest(
    @field:NotBlank(message = "title은 null, 공백, 띄어쓰기가 불가합니다.")
    @field:Size(max = 20, message = "title은 최대 20자까지 입니다.")
    var title: String,

    @field:NotBlank(message = "content는 null, 공백, 띄어쓰기가 불가합니다.")
    @field:Size(max = 100, message = "content는 최대 1000자까지 입니다")
    var content: String,

    @field:NotBlank
    var whether: Whether,

    var image: String?,

    @field:NotBlank
    var starScore: StarScore,

    @field:NotBlank
    var sleepTime: Int,

    @field:NotBlank
    var sportTime: Int
)