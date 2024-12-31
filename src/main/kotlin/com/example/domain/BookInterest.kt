package com.example.domain

import java.time.LocalDateTime
import java.util.UUID

class BookInterest private constructor(
    val id: UUID,
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
    val status: BookInterestStatus,
    val createdDateTime: LocalDateTime,
    val updatedDateTime: LocalDateTime? = null,
) {





    companion object {
        private fun isNotDeleted(status: BookInterestStatus) = status != BookInterestStatus.DELETED

        fun create(
            id: UUID,
            userId: String,
            title: String,
            libraryType: LibraryType,
            explanation: String,
        ): BookInterest {

            require(title.isNotBlank()) { "제목은 빈 값일수 없습니다. 제목 : $title" }
            require(userId.isNotBlank()) { "ID는 빈 값일 수 없습니다. ID : $userId" }

            return BookInterest(
                id = id,
                userId = userId,
                title = title,
                libraryType = libraryType,
                explanation = explanation,
                createdDateTime = LocalDateTime.now(),
                status = BookInterestStatus.BEFORE_READING,
            )
        }


        fun delete(
            id: UUID,
            userId: String,
            title: String,
            libraryType: LibraryType,
            explanation: String,
            createdDateTime: LocalDateTime,
            status: BookInterestStatus
        ): BookInterest {

            require(isNotDeleted(status)) { "이미 삭제된 도서입니다. id : $id title : $title" }

            return BookInterest(
                id = id,
                userId = userId,
                title = title,
                libraryType = libraryType,
                explanation = explanation,
                createdDateTime = createdDateTime,
                status = BookInterestStatus.DELETED,
                updatedDateTime = LocalDateTime.now()
            )
        }


        fun modify(
            id : UUID,
            userId : String,
            createdDateTime : LocalDateTime,
            status : BookInterestStatus,
            updatedDateTime : LocalDateTime?,
            title: String,
            libraryType: LibraryType,
            explanation: String,
        ): BookInterest {

            require(title.isNotBlank()) { "제목 은 빈 값일 수 없습니다. 제목 : $title" }

            return BookInterest(
                id = id,
                userId = userId,
                title = title,
                libraryType = libraryType,
                explanation = explanation,
                createdDateTime = createdDateTime,
                status = status,
                updatedDateTime = updatedDateTime,
            )
        }

    }


}


enum class BookInterestStatus {
    BEFORE_READING, AFTER_READING, DELETED
}

