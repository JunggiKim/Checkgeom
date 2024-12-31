package com.example.service

import com.example.infrastructur.BookInterestRepository
import com.example.service.dto.request.ModifyBookInterestServiceRequest
import com.example.service.dto.request.SaveBookInterestServiceRequest
import com.example.service.dto.response.FindBookInterestServiceResponse
import com.example.service.dto.response.ModifyBookInterestServiceResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


interface BookInterestService {

    fun bookInterestSave(request: SaveBookInterestServiceRequest)

    fun bookInterestDelete(bookInterestId: UUID)

    fun findBookInterestList(userId: String): List<FindBookInterestServiceResponse>

    fun bookInterestModify(request: ModifyBookInterestServiceRequest): ModifyBookInterestServiceResponse
}


@Service
@Transactional
class BookInterestServiceImpl(
    private val bookInterestRepository: BookInterestRepository,
    private val bookInterestReader: BookInterestReader,
    private val bookInterestWriter: BookInterestWriter

) : BookInterestService {

    override fun bookInterestSave(request: SaveBookInterestServiceRequest) {

        val createdBookInterest = bookInterestWriter.createSaveBookInterest(request)

        bookInterestWriter.bookInterestSave(createdBookInterest)

    }

    override fun bookInterestDelete(bookInterestId: UUID) {

        val findBookInterest = bookInterestReader.findBookInterest(bookInterestId)

        val deletedBookInterest = bookInterestWriter.createDeleteBookInterest(findBookInterest)

        bookInterestWriter.modifybookInterest(deletedBookInterest)

    }


    override fun bookInterestModify(request: ModifyBookInterestServiceRequest): ModifyBookInterestServiceResponse {

        val findBookInterest = bookInterestReader.findBookInterest(request.id)

        val modifyBookInterest = bookInterestWriter.modifyBookInterest(findBookInterest, request)

        return bookInterestWriter.modifybookInterest(modifyBookInterest)

    }


    override fun findBookInterestList(userId: String): List<FindBookInterestServiceResponse> {
        return bookInterestReader.findByUserIdBookInterestList(userId)
    }


}