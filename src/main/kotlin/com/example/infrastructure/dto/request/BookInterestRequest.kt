package com.example.infrastructure.dto.request

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import com.example.entity.BookInterestEntity
import java.time.LocalDateTime
import java.util.UUID

data class SaveBookInterestInfraRequest(
    val id: UUID,
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
    val status: BookInterestStatus,
    val createdDateTime: LocalDateTime,
    val updatedDateTime: LocalDateTime? = null,
){
    companion object {
        fun of(
            id: UUID,
            userId: String,
            title: String,
            libraryType: LibraryType,
            explanation: String,
            status: BookInterestStatus,
            createdDateTime: LocalDateTime,
        ): SaveBookInterestInfraRequest {
            return SaveBookInterestInfraRequest(
                id = id,
                userId = userId,
                title = title,
                libraryType = libraryType,
                explanation = explanation,
                status = status,
                createdDateTime = createdDateTime
            )
        }

    }

}


data class ModifyBookInterestInfraRequest(
    val id: UUID,
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
    val status: BookInterestStatus,
    val createdDateTime: LocalDateTime,
    val updatedDateTime: LocalDateTime?,
) {
    fun toEntity(): BookInterestEntity {
        return BookInterestEntity(
            id = this.id.toString(),
            userId = this.userId,
            title = this.title,
            libraryType = this.libraryType,
            explanation = this.explanation,
            status = this.status,
            createdDateTime = this.createdDateTime,
            updatedDateTime = this.updatedDateTime
            )

    }

    companion object {
        fun of(
            id: UUID,
            userId: String,
            title: String,
            libraryType: LibraryType,
            explanation: String,
            status: BookInterestStatus,
            createdDateTime: LocalDateTime,
            updatedDateTime: LocalDateTime?
        ): ModifyBookInterestInfraRequest {
            return ModifyBookInterestInfraRequest(
                id = id,
                userId = userId,
                title = title,
                libraryType = libraryType,
                explanation = explanation,
                status = status,
                createdDateTime = createdDateTime,
                updatedDateTime = updatedDateTime
            )
        }

    }
}

