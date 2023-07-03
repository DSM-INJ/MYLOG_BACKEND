package com.example.diaryservice.global.security

import com.example.diaryservice.global.config.FilterConfig
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val objectMapper: ObjectMapper
) {
    @Bean
    @Throws(Exception::class)
    fun filterChian(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf().disable()
            .formLogin().disable()
            .cors().and()

            .sessionManagement()
            .sessionCreationPolicy(STATELESS)

            .and()
            .authorizeHttpRequests()
            .antMatchers("/**").permitAll()

            .and().apply(FilterConfig(objectMapper))
            .and().build()
    }

    @Bean
    fun passwordEncorder(): PasswordEncoder = BCryptPasswordEncoder()
}