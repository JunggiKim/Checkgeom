package com.example.service

import com.example.domain.User
import com.example.infrastructure.UserRepository
import com.example.infrastructure.dto.request.SignupUserInfraRequest
import com.example.util.getUuid
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class UserServiceWriter(
    private val userRepository: UserRepository
) {

    fun createUser(userId: String) = User.create(
        id = getUuid(),
        userId = userId,
        createdDateTime = LocalDateTime.now()
    )


    fun userSignup(createUser: User) {

        val signupUserInfraRequest = SignupUserInfraRequest.of(
            id = createUser.id,
            userId = createUser.userId,
            createdDateTime = createUser.createdDateTime,
            authName = createUser.authName,
            authCode = createUser.authCode,
        )

        userRepository.signup(signupUserInfraRequest)
    }


}