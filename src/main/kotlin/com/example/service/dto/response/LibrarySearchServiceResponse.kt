package com.example.service.dto.response

import side.project.checkgeom_severless.repository.response.LibraryInfraResponse


data class LibrarySearchServiceResponse(
    val bookDtoList: List<BookDto>,
    val bookSearchTotalCount: Int,
    val moreViewLink: List<String>,
    val libraryTypeText: String
) {

    data class BookDto(
        val title: String,
        val author: String,
        val publisher: String,
        val publicationDate: String,
        val loanReservationAvailability: String
    ) {
        companion object {
            fun of(
                repositoryResponse: LibraryInfraResponse
            )  = BookDto(
                    title = repositoryResponse.title,
                    author = repositoryResponse.author,
                    publisher = repositoryResponse.publisher,
                    publicationDate = repositoryResponse.publicationDate,
                    loanReservationAvailability = repositoryResponse.loanReservationAvailability
                )

            fun of(
                title: String,
                author: String,
                publisher: String,
                publicationDate: String,
                loanReservationAvailability: String
            ) =  BookDto(
                   title = title,
                   author = author,
                   publisher = publisher,
                   publicationDate = publicationDate,
                   loanReservationAvailability = loanReservationAvailability
                )
        }
    }

    companion object {
        fun of(
            bookDtoList: List<BookDto>,
            bookSearchTotalCount: Int,
            moreViewLink: List<String>,
            libraryTypeText: String
        ): LibrarySearchServiceResponse {
            return LibrarySearchServiceResponse(
                bookDtoList = bookDtoList,
                bookSearchTotalCount = bookSearchTotalCount,
                moreViewLink = moreViewLink,
                libraryTypeText = libraryTypeText
            )
        }
    }
}