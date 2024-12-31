package com.example.presentation

import com.example.presentation.dto.request.UserIdRequest
import com.example.service.UserService
import com.example.util.getBody
import com.example.util.getQueryStrings
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import java.util.function.Function


private val objectMapper = ObjectMapper()

@Configuration
class UserHandler(
    private val userService: UserService,

) {


    @Bean
    fun login(): Function<Map<String, Any>, ResponseEntity<Any>> {
        return Function { input: Map<String, Any> ->
            println("인풋임 = $input")

            val userIdRequest = getBody<UserIdRequest>(input)

            println("userId = $userIdRequest")
            ResponseEntity.ok().body(userService.login(userIdRequest.userId))
        }
    }

    @Bean
    fun signup(): Function<Map<String, Any>, ResponseEntity<Any>> {
        return Function { input: Map<String, Any> ->
            println("인풋임 = $input")

            val userIdRequest = getBody<UserIdRequest>(input)

            println("userId = $userIdRequest")
            ResponseEntity.ok().body(userService.signup(userIdRequest.userId))
        }
    }


    // 어드민 회원가입도 만들어두자
    @Bean
    fun adminSignup(): Function<Map<String, Any>, ResponseEntity<Any>> {
        return Function { input: Map<String, Any> ->
            println("인풋임 = $input")

            val userIdRequest = getBody<UserIdRequest>(input)

            println("userId = $userIdRequest")
            ResponseEntity.ok().body(userService.signup(userIdRequest.userId))
        }
    }

}
