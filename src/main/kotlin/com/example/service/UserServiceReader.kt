package com.example.service

import com.example.infrastructure.UserRepository
import com.example.infrastructure.dto.response.FindUserInfraResponse
import org.springframework.stereotype.Service


@Service
class UserServiceReader(
    private val userRepository: UserRepository
) {

    fun findUser(userId: String): FindUserInfraResponse {
        return userRepository.findUser(userId)
    }

    fun duplicateUserCheck(userId: String): Boolean {
        return userRepository.findUser(userId).id != null
    }

    fun duplicateUserValidation(userId: String) {
        if (duplicateUserCheck(userId)) {
            throw IllegalArgumentException("이미 존재하는 아이디입니다. 아이디 : $userId")
        }
    }

}