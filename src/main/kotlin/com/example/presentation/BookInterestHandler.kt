package com.example.presentation

import com.example.presentation.dto.request.DeleteBookInterestPresentationRequest
import com.example.presentation.dto.request.ModifyBookInterestPresentationRequest
import com.example.presentation.dto.request.SaveBookInterestPresentationRequest
import com.example.service.BookInterestService
import com.example.util.getBody
import com.example.util.getQueryStrings
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import java.util.*
import java.util.function.Function

@Configuration
class BookInterestHandler(
    private val bookInterestService: BookInterestService,
) {

    @Bean
    fun bookInterestSave(): Function<Map<String, Any>, ResponseEntity<Any>> {
        return Function { input: Map<String, *> ->
            println("인풋임 = $input")

            val bookInterestListSaveRequest = getBody<SaveBookInterestPresentationRequest>(input)

            ResponseEntity.ok().body(
                bookInterestService.bookInterestSave(bookInterestListSaveRequest.toServiceRequest())
            )
        }
    }


    @Bean
    fun bookInterestDelete(): Function<Map<String, Any>, ResponseEntity<Any>> {
        return Function { input: Map<String, Any> ->
            println("인풋임 = $input")

            val stringBookInterestId = getQueryStrings<String>(input, "bookInterestId")
            val bookInterestId = UUID.fromString(stringBookInterestId)

            ResponseEntity.ok().body(bookInterestService.bookInterestDelete(bookInterestId))
        }
    }

    @Bean
    fun bookInterestList(): Function<Map<String, Any>, ResponseEntity<Any>> {
        return Function { input: Map<String, Any> ->
            println("인풋임 = $input")
//            val queryStringParameters = input["queryStringParameters"] as? Map<*, *>
//            val userId = queryStringParameters?.get("userId")?.toString() ?: ""
            val userId = getQueryStrings<String>(input, "userId")

            println("userId = $userId")
            ResponseEntity.ok().body(bookInterestService.findBookInterestList(userId))
        }
    }

    @Bean
    fun bookInterestModify(): Function<Map<String, Any>, ResponseEntity<Any>> {
        return Function { input: Map<String, Any> ->
            println("인풋임 = $input")

            val request = getBody<ModifyBookInterestPresentationRequest>(input)

            println("request = $request")
            ResponseEntity.ok().body(bookInterestService.bookInterestModify(request.toServiceRequest()))
        }
    }


}




