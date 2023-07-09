package com.example.mylogbackend

import com.example.mylogbackend.global.security.jwt.JwtProperties
import com.example.mylogbackend.infrastructure.feign.properties.FacebookFeignProperties
import com.example.mylogbackend.infrastructure.feign.properties.GoogleFeignProperties
import com.example.mylogbackend.infrastructure.feign.properties.KakaoFeignProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(
    JwtProperties::class,
    GoogleFeignProperties::class,
    KakaoFeignProperties::class,
    FacebookFeignProperties::class
)
@SpringBootApplication
class MylogBackendApplication

fun main(args: Array<String>) {
    runApplication<MylogBackendApplication>(*args)
}
