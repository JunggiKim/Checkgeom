package com.example.service

import com.example.domain.*
import com.example.infrastructure.*
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import com.example.service.dto.response.AllLibraryServiceResponse
import com.example.service.dto.response.LibrarySearchServiceResponse
import java.time.LocalDateTime


interface LibrarySearchService {

    fun gyeonggiEducation(searchKeyword: String): LibrarySearchServiceResponse

    fun smallBusiness(searchKeyword: String): LibrarySearchServiceResponse

    fun hongikUniversity(searchKeyword: String): LibrarySearchServiceResponse

    fun inhaGongjeonUniversity(searchKeyword: String): LibrarySearchServiceResponse

    fun yonginLibrary(searchKeyword: String): LibrarySearchServiceResponse

    suspend fun allLibraryAsync(searchKeyword: String): AllLibraryServiceResponse
}


@Service
class LibrarySearchServiceImpl(
    private val gyeonggiEducationReader: GyeonggiEducationReader,
    private val smallBusinessLibraryReader: SmallBusinessLibraryReader,
    private val hongikUniversityReader: HongikUniversityReader,
    private val inhagongjeonReader: InhaGongjeonReader,
    private val yonginLibraryReader: YonginLibraryReader,
) : LibrarySearchService {

    private val log: Logger = LoggerFactory.getLogger(javaClass)


    // 기본 검색한 책 목록과 책 총 결과 수 와 검색결과 모두 볼수있는 더보기링크 까지 보내주자
    override fun gyeonggiEducation(searchKeyword: String): LibrarySearchServiceResponse {
        val searchUrl: String = GyeonggiEducation.basicSearchUrlCreate(searchKeyword)
        LocalDateTime.MIN
        val htmlBody = Jsoup.parse(gyeonggiEducationReader.getHtml(searchUrl)).body()

        val bookItemDtos: List<LibrarySearchServiceResponse.BookDto> =
            gyeonggiEducationReader.getBookItemDtos(htmlBody)

        val totalCount: String = gyeonggiEducationReader.getBookSearchTotalCount(htmlBody)

        val moreViewLinkList: List<String> =
            gyeonggiEducationReader.getMoreViewLinks(htmlBody, searchUrl)


        println("책 값 가져온거  = $bookItemDtos")

        return LibrarySearchServiceResponse.of(
            bookDtoList = bookItemDtos,
            bookSearchTotalCount = totalCount.toInt(),
            moreViewLink = moreViewLinkList,
            libraryTypeText = LibraryType.GYEONGGI_EDUCATIONAL.koreanText
        )
    }


    override fun smallBusiness(searchKeyword: String): LibrarySearchServiceResponse {

        val searchUrl: String = SmallBusiness.basicUrlCreate(searchKeyword)

        val htmlBody: Element = Jsoup.parse(smallBusinessLibraryReader.getHtml(searchUrl)).body()

        val bookItemDtos: List<LibrarySearchServiceResponse.BookDto> = smallBusinessLibraryReader.getBooks(htmlBody)

        val totalCount: Int = smallBusinessLibraryReader.getTotalCount(htmlBody)

        val moreViewLinkList: List<String> = smallBusinessLibraryReader.getMoreViewLinks(searchKeyword, totalCount)

        println("책 값 가져온거  = $bookItemDtos")
        return LibrarySearchServiceResponse.of(
            bookDtoList = bookItemDtos,
            bookSearchTotalCount = totalCount,
            moreViewLink = moreViewLinkList,
            libraryTypeText = LibraryType.SMALL_BUSINESS.koreanText
        )
    }

    override fun hongikUniversity(searchKeyword: String): LibrarySearchServiceResponse {

        val searchUrl = HongikUniversity.basicSearchUrlCreate(searchKeyword)

        val html = hongikUniversityReader.getHtml(searchUrl)

        val htmlBody = Jsoup.parse(html).body().select("div.contents")

        val bookItemDtos = hongikUniversityReader.getBooks(htmlBody)

        val totalCount: Int = hongikUniversityReader.getTotalCount(htmlBody)

        val moreViewLinkList = listOf(HongikUniversity.moreViewSearchUrlCreate(searchKeyword, totalCount))


        return LibrarySearchServiceResponse.of(
            bookDtoList = bookItemDtos,
            bookSearchTotalCount = totalCount,
            moreViewLink = moreViewLinkList,
            libraryTypeText = LibraryType.HONGIK_UNIVERSITY.koreanText
        )
    }

    override fun inhaGongjeonUniversity(searchKeyword: String): LibrarySearchServiceResponse {

        val searchUrl = InhaGongjeonUniversity.basicSearchUrlCreate(searchKeyword)

        val html = inhagongjeonReader.getHtml(searchUrl)

        val htmlBody = Jsoup.parse(html).body().select("div.contents")

        val bookItemDtos = inhagongjeonReader.getBooks(htmlBody)

        val totalCount: Int = inhagongjeonReader.getTotalCount(htmlBody)

        val moreViewLinkList = listOf(InhaGongjeonUniversity.moreViewSearchUrlCreate(searchKeyword, totalCount))

        return LibrarySearchServiceResponse.of(
            bookDtoList = bookItemDtos,
            bookSearchTotalCount = totalCount,
            moreViewLink = moreViewLinkList,
            libraryTypeText = LibraryType.INHAGONGJEON_UNIVERSITY.koreanText
        )
    }

    override fun yonginLibrary(searchKeyword: String): LibrarySearchServiceResponse {

        val bodyParameter = YonginCity.bodyCreate(searchKeyword)

        val searchUrl = YonginCity.basicSearchUrlCreate()

        val html = yonginLibraryReader.getHtml(searchUrl, bodyParameter)

        val bookItemDtos = yonginLibraryReader.getBooks(html)

        val totalCount = yonginLibraryReader.getTotalCount(html)

        return LibrarySearchServiceResponse.of(
            bookDtoList = bookItemDtos,
            bookSearchTotalCount = totalCount,
            moreViewLink = listOf(),
            libraryTypeText = LibraryType.YONGIN_CITY.koreanText
        )
    }

    override suspend fun allLibraryAsync(searchKeyword: String): AllLibraryServiceResponse = coroutineScope {
        val smallBusinessResponse = async { smallBusiness(searchKeyword) }
        val gyeonggiEducationalElectronicResponse = async { gyeonggiEducation(searchKeyword) }
        val hongikUniversityResponse = async { hongikUniversity(searchKeyword) }
        val inhaGongjeonUniversityResponse = async { inhaGongjeonUniversity(searchKeyword) }

        val resultList = listOf(
            gyeonggiEducationalElectronicResponse,
            smallBusinessResponse,
            hongikUniversityResponse,
            inhaGongjeonUniversityResponse
        ).awaitAll()

        AllLibraryServiceResponse.of(resultList, LibraryType.ALL.koreanText)
    }


//
//    public AllLibraryServiceResponse allLibraryVirtualThreadAsyncSearch(String searchKeyword) throws ExecutionException, InterruptedException {
    //
    //     Future<LibrarySearchServiceResponse> gyeonggiDoCyberResponse =
    //             virtualThreadExecutor.submit(() -> gyeonggiDoCyberLibrarySearch(searchKeyword, searchType));
    //     Future<LibrarySearchServiceResponse> gyeonggiEducationalElectronicResponse =
    //             virtualThreadExecutor.submit(() -> gyeonggiEducationalElectronicLibrarySearch(searchKeyword));
    //     Future<LibrarySearchServiceResponse> smallBusinessResponse =
    //             virtualThreadExecutor.submit(() -> smallBusinessLibrarySearch(searchKeyword));
    //     List<LibrarySearchServiceResponse> resultList = List.of(
    //                     gyeonggiDoCyberResponse.get(),
    //                     gyeonggiEducationalElectronicResponse.get(),
    //                     smallBusinessResponse.get()
    //             );
    //
    //     return AllLibraryServiceResponse.of(resultList, LibraryType.ALL.getKoreanText());
    // }

}
