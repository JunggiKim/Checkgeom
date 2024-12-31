package com.example.infrastructure.dto.request

import com.example.domain.UserAuth
import com.example.entity.UserEntity
import java.time.LocalDateTime
import java.util.*


data class SignupUserInfraRequest(
    val id: UUID,
    val userId: String,
    val createdDateTime: LocalDateTime,
    val authName: UserAuth,
    val authCode: Int,
) {

    fun toEntity(): UserEntity {
        return UserEntity(
            id = id.toString(),
            userId = userId,
            createdDateTime = createdDateTime,
            authName = authName,
            authCode = authCode,
        )
    }

    companion object {
        fun of(
            id: UUID,
            userId: String,
            createdDateTime: LocalDateTime,
            authName: UserAuth,
            authCode: Int,
        ): SignupUserInfraRequest {
            return SignupUserInfraRequest(
                id = id,
                userId = userId,
                createdDateTime = createdDateTime,
                authName = authName,
                authCode = authCode,
            )
        }
    }
}