package com.example.service.dto.response

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import com.example.infrastructure.dto.InfrastructureBookInterestDto
import com.example.infrastructure.dto.response.FindBookInterestInfraResponse
import com.example.infrastructure.dto.response.ModifyBookInterestInfraResponse
import java.util.*


data class ModifyBookInterestServiceResponse(
    val id: UUID,
    val userId: String,
    val title: String,
    val libraryType: String,
    val explanation: String,
    val status: BookInterestStatus,
) {


    companion object {
        fun of(
          response: ModifyBookInterestInfraResponse
        ): ModifyBookInterestServiceResponse {
            return ModifyBookInterestServiceResponse(
                id = response.id,
                userId = response.userId,
                title = response.title,
                libraryType = response.libraryType.koreanText,
                explanation = response.explanation,
                status = response.status,
            )
        }
    }
}



data class FindBookInterestServiceResponse (
    val id: UUID,
    val userId: String,
    val title: String,
    val libraryType: String,
    val explanation: String,
) {


    companion object {
        fun of(
            response : FindBookInterestInfraResponse
        ): FindBookInterestServiceResponse {
            return FindBookInterestServiceResponse(
                id = UUID.fromString(response.id),
                userId = response.userId,
                title = response.title,
                libraryType = response.libraryType.koreanText,
                explanation = response.explanation
            )
        }
    }

}



