package com.example.presentation.dto.request

import com.example.domain.LibraryType
import com.example.service.dto.request.ModifyBookInterestServiceRequest
import com.example.service.dto.request.SaveBookInterestServiceRequest
import java.time.LocalDateTime
import java.util.*

data class SaveBookInterestPresentationRequest(
    val userId: String,
    val title: String,
    val libraryType: LibraryType,
    val explanation: String,
) {

    fun toServiceRequest(): SaveBookInterestServiceRequest {

        return SaveBookInterestServiceRequest(
            userId = this.userId,
            title = this.title,
            libraryType = this.libraryType,
            explanation = this.explanation
        )
    }

}


data class ModifyBookInterestPresentationRequest(
    val id: UUID,
    val title: String,
    val libraryType: String,
    val explanation: String,
){
    fun toServiceRequest(): ModifyBookInterestServiceRequest {
        return ModifyBookInterestServiceRequest(
            id = id,
            title = title,
            libraryType = LibraryType.fromKoreanText(libraryType),
            explanation = explanation,
        )
    }

}



data class DeleteBookInterestPresentationRequest(
    val bookInterestId: UUID,
){

}

