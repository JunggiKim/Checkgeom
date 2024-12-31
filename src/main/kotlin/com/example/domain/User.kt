package com.example.domain

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

class User private constructor(
    val id: UUID,
    val userId: String,
    val createdDateTime: LocalDateTime,
    val updatedDateTime: LocalDateTime? = null,
    val authName: UserAuth,
    val authCode: Int,
) {
    companion object {
        fun create(
            id: UUID,
            userId: String,
            createdDateTime: LocalDateTime,
        ): User {

            require(userId.isNotBlank()) { "ID는 빈 값 일 수 없습니다. ID : $userId " }
            require(
                LocalDateTime.now().isAfter(createdDateTime)
            ) { "생성 시간은 현재 시간보다 늦은 시간 일 수 없습니다 생성 시간: $createdDateTime 현재 시간: ${LocalDateTime.now()} " }

            return User(
                id = id,
                userId = userId,
                createdDateTime = createdDateTime,
                authName = UserAuth.USER,
                authCode = UserAuth.USER.code
            )
        }

        fun adminCreate(
            id: UUID,
            userId: String,
            createdDateTime: LocalDateTime,
        ): User {

            require(userId.isNotBlank()) { "ID는 빈 값 일 수 없습니다. ID : $userId " }
            require(
                LocalDateTime.now().isAfter(createdDateTime)
            ) { "생성 시간은 현재 시간보다 빠른 시간 일 수 없습니다 : $createdDateTime " }

            return User(
                id = id,
                userId = userId,
                createdDateTime = createdDateTime,
                authName = UserAuth.ADMIN,
                authCode = UserAuth.ADMIN.code
            )
        }
    }
}

enum class UserAuth(
    val code: Int
) {
    USER(1),
    ADMIN(100)
}