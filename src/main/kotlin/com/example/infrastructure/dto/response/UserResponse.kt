package com.example.infrastructure.dto.response

import com.example.domain.UserAuth
import com.example.entity.UserEntity
import java.time.LocalDateTime
import java.util.*


data class FindUserInfraResponse (
    val id: UUID?,
    val userId: String?,
    val createdDateTime: LocalDateTime?,
    val updatedDateTime: LocalDateTime?,
    val authName: UserAuth?,
    val authCode: Int?,
) {
    companion object {
        fun of(
            userEntity: UserEntity?
        ): FindUserInfraResponse {
            return FindUserInfraResponse(
                id = UUID.fromString(userEntity?.id),
                userId = userEntity?.userId,
                createdDateTime = userEntity?.createdDateTime,
                updatedDateTime = userEntity?.updatedDateTime,
                authName = userEntity?.authName,
                authCode = userEntity?.authCode,
            )
        }
    }
}