package com.example.service

import com.example.domain.BookInterest
import com.example.infrastructur.BookInterestRepository
import com.example.infrastructure.dto.request.ModifyBookInterestInfraRequest
import com.example.infrastructure.dto.request.SaveBookInterestInfraRequest
import com.example.service.dto.ServiceBasicBookInterestDto
import com.example.service.dto.request.ModifyBookInterestServiceRequest
import com.example.service.dto.request.SaveBookInterestServiceRequest
import com.example.service.dto.response.ModifyBookInterestServiceResponse
import com.example.util.getUuid
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class BookInterestWriter(
    private val bookInterestRepository: BookInterestRepository,
) {


    fun bookInterestSave(createdBookInterest: BookInterest) {
        val infrastructureRequest = SaveBookInterestInfraRequest.of(
            createdBookInterest.id,
            createdBookInterest.userId,
            createdBookInterest.title,
            createdBookInterest.libraryType,
            createdBookInterest.explanation,
            createdBookInterest.status,
            createdBookInterest.createdDateTime,
        )

        bookInterestRepository.bookInterestSave(infrastructureRequest)
    }

    fun createSaveBookInterest(request: SaveBookInterestServiceRequest) =
        BookInterest.create(
            id = getUuid(),
            userId = request.userId,
            title = request.title,
            libraryType = request.libraryType,
            explanation = request.explanation
        )


    fun createDeleteBookInterest(findBookInterest: ServiceBasicBookInterestDto): BookInterest {
        return BookInterest.delete(
            id = findBookInterest.id,
            userId = findBookInterest.userId,
            title = findBookInterest.title,
            libraryType = findBookInterest.libraryType,
            explanation = findBookInterest.explanation,
            status = findBookInterest.status,
            createdDateTime = findBookInterest.createdDateTime,
        )
    }


    fun modifybookInterest(modifyBookInterest: BookInterest): ModifyBookInterestServiceResponse {
        val modifyBookInterestInfrastructureRequest = ModifyBookInterestInfraRequest.of(
            id = modifyBookInterest.id,
            userId = modifyBookInterest.userId,
            title = modifyBookInterest.title,
            libraryType = modifyBookInterest.libraryType,
            explanation = modifyBookInterest.explanation,
            status = modifyBookInterest.status,
            createdDateTime = modifyBookInterest.createdDateTime,
            updatedDateTime = modifyBookInterest.updatedDateTime
        )
        val modifyBookInterestInfrastructureResponse =
            bookInterestRepository.bookInterestModify(modifyBookInterestInfrastructureRequest)


        return ModifyBookInterestServiceResponse.of(modifyBookInterestInfrastructureResponse)
    }


    fun modifyBookInterest(
        findBookInterest: ServiceBasicBookInterestDto,
        request: ModifyBookInterestServiceRequest
    ): BookInterest {
        return BookInterest.modify(
            id = findBookInterest.id,
            userId = findBookInterest.userId,
            title = request.title,
            libraryType = request.libraryType,
            explanation = request.explanation,
            status = findBookInterest.status,
            createdDateTime = findBookInterest.createdDateTime,
            updatedDateTime = LocalDateTime.now(),
        )

    }

}