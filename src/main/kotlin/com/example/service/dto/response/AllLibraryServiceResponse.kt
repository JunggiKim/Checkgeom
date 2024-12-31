package com.example.service.dto.response

import side.project.checkgeom_severless.repository.response.LibraryInfraResponse


data class AllLibraryServiceResponse(
    val librarySearchServiceResponseList: List<LibrarySearchServiceResponse>,
    val libraryTypeText: String
) {
    data class BookDto(
        val bookImageLink: String,
        val title: String,
        val author: String,
        val publisher: String,
        val publicationDate: String,
        val loanReservationAvailability: String
    ) {
        companion object {
            fun of(
                repositoryResponse: LibraryInfraResponse
            ): BookDto {
                return BookDto(
                   bookImageLink= repositoryResponse.bookImageLink,
                   title= repositoryResponse.title,
                   author= repositoryResponse.author,
                   publisher= repositoryResponse.publisher,
                   publicationDate= repositoryResponse.publicationDate,
                   loanReservationAvailability= repositoryResponse.loanReservationAvailability
                )
            }

            fun of(
                bookImageLink: String,
                title: String,
                author: String,
                publisher: String,
                publicationDate: String,
                loanReservationAvailability: String
            ): BookDto {
                return BookDto(
                   bookImageLink= bookImageLink,
                   title= title,
                   author= author,
                   publisher= publisher,
                   publicationDate= publicationDate,
                   loanReservationAvailability= loanReservationAvailability
                )
            }
        }
    }

    companion object {
        fun of(
            librarySearchServiceResponseList: List<LibrarySearchServiceResponse>,
            libraryTypeText: String
        ): AllLibraryServiceResponse {
            return AllLibraryServiceResponse(
               librarySearchServiceResponseList =  librarySearchServiceResponseList,
                libraryTypeText =  libraryTypeText)
        }
    }
}