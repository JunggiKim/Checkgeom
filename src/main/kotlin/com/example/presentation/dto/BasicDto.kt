package com.example.presentation.dto

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import java.time.LocalDateTime

data class PersistenceBasicBookInterestDto (
    val id: Long?,
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
    val status: BookInterestStatus,
    val createdDateTime: LocalDateTime?,
    val updatedDateTime: LocalDateTime? = null,
)