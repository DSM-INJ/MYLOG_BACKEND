package com.example.diaryservice.global.filter

import com.example.diaryservice.global.error.ErrorResponse
import com.example.diaryservice.global.error.exception.MyLogException
import com.example.diaryservice.global.exception.InternalServerError
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e:Exception) {
            e.printStackTrace()
            when (e) {
                is MyLogException -> writeErrorCode(e, response)
                else -> writeErrorCode(InternalServerError, response)
            }
        }
    }

    private fun writeErrorCode(e:MyLogException, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(e)

        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = errorResponse.status
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}