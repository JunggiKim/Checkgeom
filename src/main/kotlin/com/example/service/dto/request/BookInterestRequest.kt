package com.example.service.dto.request

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import com.example.infrastructure.dto.request.SaveBookInterestInfraRequest
import java.time.LocalDateTime
import java.util.UUID

data class SaveBookInterestServiceRequest(
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
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




data class ModifyBookInterestServiceRequest(
    val id: UUID,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
)


