package com.example.infrastructure.dto

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import java.time.LocalDateTime
import java.util.UUID

data class InfrastructureBookInterestDto (
    val id: UUID,
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
    val status: BookInterestStatus,
    val createdDateTime: LocalDateTime,
    val updatedDateTime: LocalDateTime? = null,
)
