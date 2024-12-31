package com.example.entity

import com.example.domain.UserAuth
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "USERS")
class UserEntity(
    id: String,
    userId: String,
    createdDateTime: LocalDateTime,
    updatedDateTime: LocalDateTime? = null,
    authName: UserAuth,
    authCode: Int,
) {
    @Id
    @Column(name = "ID")
    var id: String = id
        protected set

    @Column(name = "USER_ID", nullable = false, unique = true)
    var userId: String = userId
        protected set

    @Column(name = "CREATED_DATE_TIME", nullable = false)
    var createdDateTime: LocalDateTime = createdDateTime
        protected set

    @Column(name = "UPDATED_DATE_TIME")
    var updatedDateTime: LocalDateTime? = updatedDateTime
        protected set

    @Column(name = "AUTH_NAME", nullable = false)
    @Enumerated(value = EnumType.STRING)
    var authName: UserAuth = authName
        protected set

    @Column(name = "AUTH_CODE", nullable = false)
    var authCode: Int = authCode
        protected set

}