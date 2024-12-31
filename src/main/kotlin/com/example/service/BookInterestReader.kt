package com.example.service

import com.example.infrastructur.BookInterestRepository
import com.example.service.dto.ServiceBasicBookInterestDto
import com.example.service.dto.response.FindBookInterestServiceResponse
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class BookInterestReader (
    private val bookInterestRepository: BookInterestRepository
){
    fun findBookInterest(bookInterestId : UUID) : ServiceBasicBookInterestDto{
        val findBookInterest = bookInterestRepository.findBookInterest(bookInterestId.toString())
        return ServiceBasicBookInterestDto.of(findBookInterest)
    }

    fun findByUserIdBookInterestList(userId : String) : List<FindBookInterestServiceResponse>{
        return bookInterestRepository.findByUserIdBookInterestList(userId)
            .map { FindBookInterestServiceResponse.of(it) }
            .toList()
    }
}