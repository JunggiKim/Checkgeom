package com.example.infrastructure

import com.example.domain.HongikUniversity
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import com.example.service.dto.response.LibrarySearchServiceResponse
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Component
class YonginLibraryReader (
    private val restClient: RestClient,
){

    fun getHtml(searchUrl: String , bodyParameters : MultiValueMap<String,String>): Elements {

        val headers = createHeaders()

        val bodyData = createBodyParams(bodyParameters)

        val htmlResult = restClient.post()
            .uri(searchUrl)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .headers{it.addAll(headers)}
            .body(bodyData)
            .retrieve()
            .body<String>()
            .toString()

        return Jsoup.parse(htmlResult).select("#searchForm")
    }

    private fun createHeaders(): HttpHeaders {
        val headers = HttpHeaders().apply {
            set(
                "Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
            )
            set("Accept-Encoding", "gzip, deflate, br, zstd")
            set("Accept-Language", "ko,en;q=0.9,en-US;q=0.8")
            set("Cache-Control", "max-age=0")
            set("Connection", "keep-alive")
            set("Host", "lib.yongin.go.kr")
            set("Origin", "https://lib.yongin.go.kr")
            set("Referer", "https://lib.yongin.go.kr/giheung/plusSearchResultList.do")
            set("Sec-Fetch-Dest", "document")
            set("Sec-Fetch-Mode", "navigate")
            set("Sec-Fetch-Site", "same-origin")
            set("Sec-Fetch-User", "?1")
            set("Upgrade-Insecure-Requests", "1")
            set(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36 Edg/126.0.0.0"
            )
            set("sec-ch-ua", "\"Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Microsoft Edge\";v=\"126\"")
            set("sec-ch-ua-mobile", "?0")
            set("sec-ch-ua-platform", "\"Windows\"")
            set(
                "Cookie",
                "WMONID=jnjUDVStKRz; _fwb=251IKVFxTe3GKH1j5QzMfAE.1733278291871; _ga=GA1.1.1414621887.1733278293; JSESSIONID=6QB3yOG1PYwbzX2gd5svDbC1Cw1E1w1bsF66OaTcFVyzCKJYvJvpbjBh3jepiSmv.amV1c19kb21haW4vc2VydmVyMQ==; wcs_bt=141b4dc9487bd9:1733361363; _ga_KQP5JL785G=GS1.1.1733358745.2.1.1733361373.0.0.0"
            )
        }
        return headers
    }

    fun getHtml2(searchUrl: String , bodyParameters : MultiValueMap<String,String>): Elements {

        val header = createHeaders()

        val bodyData = createBodyParams(bodyParameters)

        val htmlResult = restClient.post()
            .uri(searchUrl)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .headers{it.addAll(header)}
            .body(bodyData)
            .retrieve()
            .body<String>()
            .toString()

        return Jsoup.parse(htmlResult).select("ul.listWrap")
    }

    private fun createBodyParams(bodyParameters: MultiValueMap<String, String>): String {
        val bodyData = bodyParameters.entries.joinToString("&") {
            "${URLEncoder.encode(it.key , StandardCharsets.UTF_8) }=" +
                    URLEncoder.encode(it.value.joinToString(",") , StandardCharsets.UTF_8)
        }

        return bodyData
    }

    fun getBooks(htmlBody: Elements): List<LibrarySearchServiceResponse.BookDto> {

        val books = htmlBody.select("ul.listWrap > li")

        return  books.map {
            val title = it.select(".book_name a").text()

            val author = it.select(".book_info.info01 p").text()

            val publisher = it.select(".book_info.info02 p").first()?.text() ?: ""
            val publisherDate = it.select(".book_info.info02 p").last()?.text() ?: ""

            val loanReservationAvailability = it.select(".status p").first()?.text() ?: ""

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

        return HongikUniversity.decisionOnWhetherLoanReservationIsPossible(
            currentNumberOfLoans = currentNumberOfLoans.toInt(),
            totalNumberOfLoansPossible = totalNumberOfLoansPossible.toInt(),
        )
    }

    fun getTotalCount(htmlBody: Elements): Int {
        val numberText = htmlBody.select("div.result_screen strong.highlight").last()?.text()

        return numberText?.toInt() ?: 0
    }




}