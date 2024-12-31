package com.example.infrastructure

import com.example.entity.UserEntity
import com.example.infrastructure.dto.request.SignupUserInfraRequest
import com.example.infrastructure.dto.response.FindUserInfraResponse
import com.example.infrastructure.jpa.UserJpaRepository
import org.springframework.stereotype.Repository


interface UserRepository {
    fun signup(request: SignupUserInfraRequest): Boolean
    fun findUser(userId: String): FindUserInfraResponse
}


@Repository
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {

    override fun signup(request: SignupUserInfraRequest): Boolean {
        userJpaRepository.save(request.toEntity())
        return true
    }

    override fun findUser(userId: String): FindUserInfraResponse {
        val userEntity = userJpaRepository.findByUserId(userId)

        return FindUserInfraResponse.of(userEntity)
    }


}