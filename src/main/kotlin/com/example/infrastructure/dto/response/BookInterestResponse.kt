package com.example.infrastructure.dto.response

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import java.time.LocalDateTime
import java.util.UUID


data class ModifyBookInterestInfraResponse(
    val id: UUID,
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
    val status: BookInterestStatus,
    val createdDateTime: LocalDateTime,
    val updatedDateTime: LocalDateTime,
) {

    companion object {


        fun of(
            id: UUID,
            userId: String,
            title: String,
            libraryType: LibraryType,
            explanation: String,
            status: BookInterestStatus,
            createdDateTime: LocalDateTime,
            updatedDateTime: LocalDateTime,
        ): ModifyBookInterestInfraResponse {
            return ModifyBookInterestInfraResponse(
                id = id,
                userId = userId,
                title = title,
                libraryType = libraryType,
                explanation = explanation,
                status = status,
                createdDateTime = createdDateTime,
                updatedDateTime = updatedDateTime,
            )
        }

    }


}


data class FindBookInterestInfraResponse (
    val id: String,
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
)