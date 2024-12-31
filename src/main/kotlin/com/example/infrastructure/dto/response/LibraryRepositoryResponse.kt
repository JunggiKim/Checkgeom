package side.project.checkgeom_severless.repository.response

data class LibraryInfraResponse(
    val bookImageLink: String,
    val title: String,
    val author: String,
    val publisher: String,
    val publicationDate: String,
    val loanReservationAvailability: String
) {
    companion object {
        fun of(
            bookImageLink: String,
            title: String,
            author: String,
            publisher: String,
            publicationDate: String,
            loanReservationAvailability: String
        ): LibraryInfraResponse {
            return LibraryInfraResponse(
                bookImageLink = bookImageLink,
                title = title,
                author = author,
                publisher = publisher,
                publicationDate = publicationDate,
                loanReservationAvailability = loanReservationAvailability
            )
        }
    }
}
