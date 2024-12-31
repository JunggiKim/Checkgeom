package com.example.presentation

import com.example.domain.LibraryType
import com.example.service.LibrarySearchService
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.runBlocking
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import com.example.service.dto.response.AllLibraryServiceResponse
import com.example.service.dto.response.LibrarySearchServiceResponse
import com.example.util.getQueryStrings
import java.util.function.Function


private val objectMapper = ObjectMapper()

@Configuration
class SearchHandler(
    private val librarySearchService: LibrarySearchService,
) {

    @Bean
    fun gyeonggiEducationLibrarySearch(): Function<Map<String, Any>, ResponseEntity<LibrarySearchServiceResponse>> {
        return Function { input ->
            println("인풋임 = $input")
            val searchKeyword = getQueryStrings<String>(input, "searchKeyword")
            ResponseEntity.ok().body(librarySearchService.gyeonggiEducation(searchKeyword))
        }
    }

    @Bean
    fun smallBusinessLibrarySearch(): Function<Map<String, Any>, ResponseEntity<LibrarySearchServiceResponse>> {
        return Function { input ->
            println("인풋임 = $input")
            val searchKeyword = getQueryStrings<String>(input, "searchKeyword")

            ResponseEntity.ok()
                .body(librarySearchService.smallBusiness(searchKeyword))
        }
    }

    @Bean
    fun hongikUniversitySearch(): Function<Map<String, Any>, ResponseEntity<LibrarySearchServiceResponse>> {
        return Function { input ->
            println("인풋임 = $input")

            val searchKeyword = getQueryStrings<String>(input, "searchKeyword")

            ResponseEntity.ok()
                .body(librarySearchService.hongikUniversity(searchKeyword))
        }
    }

    @Bean
    fun inhaGongjeonUniversitySearch(): Function<Map<String, Any>, ResponseEntity<LibrarySearchServiceResponse>> {
        return Function { input ->
            println("인풋임 = $input")
            val searchKeyword = getQueryStrings<String>(input, "searchKeyword")

            ResponseEntity.ok()
                .body(librarySearchService.inhaGongjeonUniversity(searchKeyword))
        }
    }

    @Bean
    fun allLibrarySearch(): Function<Map<String, Any>, ResponseEntity<AllLibraryServiceResponse>> {
        return Function { input ->
            println("인풋임 = $input")
            val searchKeyword = getQueryStrings<String>(input, "searchKeyword")

            val allLibrarySearchResult = runBlocking {
                librarySearchService.allLibraryAsync(searchKeyword)
            }
            ResponseEntity.ok()
                .body(allLibrarySearchResult)
        }
    }

    // 주석 처리된 login 함수는 필요 시 동일한 방식으로 수정 가능
    /*
    @Bean
    fun login(): Function<Map<String, Any>, ResponseEntity<LibrarySearchServiceResponse>> {
        return Function { input ->
            println("인풋임 = $input")
            val queryStringParameters = input["queryStringParameters"] as? Map<*, *>
            val searchKeyword = queryStringParameters?.get("searchKeyword")?.toString() ?: ""

            ResponseEntity.ok()
                .body(librarySearchService.inhaGongjeonUniversity(searchKeyword))
        }
    }
    */
}
