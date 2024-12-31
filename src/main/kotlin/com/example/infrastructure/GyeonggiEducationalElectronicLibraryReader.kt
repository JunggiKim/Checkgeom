package com.example.infrastructure


import com.example.domain.GyeonggiEducation
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import com.example.domain.MoreView
import org.jsoup.nodes.Element
import com.example.service.dto.response.LibrarySearchServiceResponse
import java.util.*

@Component
class GyeonggiEducationReader (
    private val restClient: RestClient
){

    fun getHtml(searchUrl: String): String {
        return restClient.get()
            .uri(searchUrl)
            .retrieve()
            .body<String>()
            .toString()
    }

    fun getMoreViewLinks(htmlBody: Element, searchUrl: String?): List<String> {
        val moreViewLinkList: MutableList<String> = ArrayList()
        val moreView: MoreView = gyeonggiEducationalElectronicLibraryIsMoreView(htmlBody)

        if (moreView.isMoreView) {
            val moreViewUrl: String =
                GyeonggiEducation.moreViewSearchUrlCreate(searchUrl, moreView.totalCount)
            moreViewLinkList.add(moreViewUrl)
        }
        return moreViewLinkList
    }

    fun getBookSearchTotalCount(htmlBody: Element): String {
        return htmlBody.select("b#book_totalDataCount").text()
    }


    fun getBookItemDtos(htmlBody: Element): List<LibrarySearchServiceResponse.BookDto> {
        val select = htmlBody.select("div.row")

        val bookDtoList: MutableList<LibrarySearchServiceResponse.BookDto> =
            ArrayList<LibrarySearchServiceResponse.BookDto>()


        for (element in select) {
            val bookTitle = element.select("a.name.goDetail").text()
//            val bookImageLink = element.select("a.goDetail img").attr("src")

            val bookDetailInfo =
                element.select("div p").text().split("│".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val bookDetailInfoList = Arrays.stream(bookDetailInfo)
                .map { bookInfo: String -> this.extractBookDetails(bookInfo) }.toList()

            //            인덱스 순서
            // 저자, 출판사, 출판일 ,도서관 대출가능여부 (대출 ,예약 두개있을수도 있음) ,자료유형 전자책
            val bookDto: LibrarySearchServiceResponse.BookDto = LibrarySearchServiceResponse.BookDto.of(
                title = bookTitle,
                author = bookDetailInfoList[0],
                publisher = bookDetailInfoList[1],
                publicationDate = bookDetailInfoList[2],
                loanReservationAvailability = bookDetailInfoList[3]
            )

            bookDtoList.add(bookDto)

        }

        return bookDtoList



    }

    private fun extractBookDetails(bookInfo: String): String {
        val index = bookInfo.indexOf(":")
        val subStringed = bookInfo.substring(index + 1)
        val index1 = subStringed.indexOf(":") // 경기교육통합도서관대출 가능 여부 :  <- 문자 또 제거
        return subStringed.substring(index1 + 1)
    }


    private fun gyeonggiEducationalElectronicLibraryIsMoreView(htmlBody: Element): MoreView {
        val totalCount = htmlBody.select("b#book_totalDataCount").text()
        return MoreView.create(totalCount.toInt())
    }

}
