package com.example.infrastructure

import org.jsoup.nodes.Element
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import com.example.domain.MoreView
import com.example.domain.SmallBusiness
import com.example.service.dto.response.LibrarySearchServiceResponse
import java.util.regex.Pattern

@Component
class SmallBusinessLibraryReader (
    private val restClient: RestClient
){

    fun getHtml(searchUrl: String): String {
        return restClient.get()
            .uri(searchUrl)
            .retrieve()
            .body<String>()
            .toString();
    }




    fun getBooks(htmlBody: Element): List<LibrarySearchServiceResponse.BookDto> {
        val selectBookList = htmlBody.select("ul.book_resultList > li")

        return selectBookList.stream().map { mapBookDto(it)}
            .toList()
    }

    private fun mapBookDto(element: Element): LibrarySearchServiceResponse.BookDto {
        val bookTitle = element.select("li.tit a").text()
        val bookDetailInfo = element.select("li.writer").toString()
        val pattern = Pattern.compile("<li class=\"writer\">(.*?)<span>(.*?)</span>(\\d{4}-\\d{2}-\\d{2})</li>")
        val matcher = pattern.matcher(bookDetailInfo)
        if (matcher.find()) {
            val author = matcher.group(1) // 저자
            val publisher = matcher.group(2) // 출판사
            val publicationDate = matcher.group(3) // 출판 날짜

            return LibrarySearchServiceResponse.BookDto.of(
                title = bookTitle,
                author = author,
                publisher = publisher,
                publicationDate = publicationDate,
                loanReservationAvailability = "대출 가능"
            )
        }
        throw RuntimeException("$element 의 정상적인 변환을 하지 못했습니다.")
    }

    fun getTotalCount(htmlBody: Element): Int {
        val totalCount = htmlBody.select("div.book_resultTxt p").toString().replace("[^0-9]".toRegex(), "")
        val stringTotalCount = if (totalCount.isBlank()) "0" else totalCount
        return stringTotalCount.toInt()
    }


    fun getMoreViewLinks(searchKeyword: String?, totalCount: Int): List<String> {
        val moreView: MoreView = MoreView.create(totalCount)

        val moreViewUrlList: MutableList<String> = ArrayList()

        if (moreView.isMoreView) {
            val moreViewUrl: String = SmallBusiness.moreViewUrlCreate(searchKeyword, totalCount)
            moreViewUrlList.add(moreViewUrl)
        }

        return moreViewUrlList
    }
}
