package com.example.service.dto

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import com.example.infrastructure.dto.InfrastructureBookInterestDto
import java.time.LocalDateTime
import java.util.*

data class ServiceBasicBookInterestDto(
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

        fun of(response: InfrastructureBookInterestDto): ServiceBasicBookInterestDto {
          return ServiceBasicBookInterestDto(
                id = response.id,
                userId = response.userId,
                title = response.title,
                libraryType = response.libraryType,
                explanation = response.explanation,
                status = response.status,
                createdDateTime = response.createdDateTime,
                updatedDateTime = response.updatedDateTime,
            )
        }
    }

}