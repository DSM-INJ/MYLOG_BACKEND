package com.example.mylogbackend.infrastructure.feign.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("MyLog API")
                    .description("대프콘만을 위한 MyLog API 명세서입니다;..")
                    .version("v1")
            )
    }
}