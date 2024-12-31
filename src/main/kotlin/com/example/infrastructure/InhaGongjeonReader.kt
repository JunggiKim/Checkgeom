package com.example.infrastructure

import com.example.domain.InhaGongjeonUniversity
import org.jsoup.select.Elements
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import com.example.service.dto.response.LibrarySearchServiceResponse


@Component
class InhaGongjeonReader(
    private val restClient: RestClient
) {


    fun getHtml(searchUrl: String): String {
        return restClient.get()
            .uri(searchUrl)
            .retrieve()
            .body<String>()
            .toString()
    }

    fun getBooks(htmlBody: Elements): List<LibrarySearchServiceResponse.BookDto> {


        val books = htmlBody.select("ul.book_resultList > li")


        return books.map {
            val title = it.select("ul li.tit a").text()

            val authorInfo = it.select("ul li.writer").first()
            val author = authorInfo?.textNodes()?.first { it.toString() != authorInfo.select("span").text() }.toString()
            val publisher = authorInfo?.select("span")!!.text()
            val publisherDate = authorInfo.textNodes().last().text()

            val loanReservationInfo = it.select("p.use").text()
            val loanReservationAvailability = getLoanReservationAvailability(loanReservationInfo)

            LibrarySearchServiceResponse.BookDto.of(
                title = title,
                author = author,
                publisher = publisher,
                publicationDate = publisherDate,
                loanReservationAvailability = loanReservationAvailability,
            )
        }
    }

    private fun getLoanReservationAvailability(loanReservationInfo: String): String {
        val loanPattern = "대출 : (\\d+)/(\\d+)".toRegex()
        val loanAvailabilityInfo = loanPattern.find(loanReservationInfo)
        val currentNumberOfLoans = loanAvailabilityInfo?.groupValues?.get(1) ?: "0"
        val totalNumberOfLoansPossible = loanAvailabilityInfo?.groupValues?.get(2) ?: "0"

//        val reservationPattern = "예약 : (\\d+)".toRegex()
//        val reservationAvailability = reservationPattern.find(loanReservationInfo)
//        val currentNumberOfReservations = reservationAvailability?.groupValues?.get(1) ?: "0"

        return InhaGongjeonUniversity.decisionOnWhetherLoanReservationIsPossible(
            currentNumberOfLoans = currentNumberOfLoans.toInt(),
            totalNumberOfLoansPossible = totalNumberOfLoansPossible.toInt(),
        )
    }

    fun getTotalCount(htmlBody: Elements): Int {
        val totalCountText = htmlBody.select("div.book_resultTxt strong").last()?.text()
        println("인하공전에서 가져온값 = $totalCountText")
        val totalCount = totalCountText?.replace(Regex("[^0-9]"), "")

        return if(totalCount.isNullOrBlank()) 0 else totalCount.toInt()
    }


}