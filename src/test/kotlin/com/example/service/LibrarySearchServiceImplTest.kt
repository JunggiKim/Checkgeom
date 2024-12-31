//package com.example.service
//
//import kotlinx.coroutines.runBlocking
//import org.junit.jupiter.api.DisplayName
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//
//
//@ActiveProfiles("test")
//@SpringBootTest
//class LibrarySearchServiceImplTest {
//
//
//    @Autowired
//    private lateinit var librarySearchService: LibrarySearchService
//
//
//    @Test
//    @DisplayName("경기교육전자도서관")
//    fun example() {
//        librarySearchService.gyeonggiEducation("스프링")
//    }
//
//    @Test
//    @DisplayName("소상공인전자도서관")
//    fun example2() {
//        librarySearchService.smallBusiness("스프링")
//    }
//
//
//
//    @Test
//    @DisplayName("홍대전자도서관임")
//    fun hongikUniversity() {
//        val hongikUniversity = librarySearchService.hongikUniversity("글")
//
//        hongikUniversity.bookDtoList.forEach { println("가져온 책 ${it.title}") }
//
//    }
//
//
//
//
//
//    @Test
//    @DisplayName("인하공전전자도서관")
//    fun inhaGongjeonUniversity() {
//        val inhaGongjeonUniversity = librarySearchService.inhaGongjeonUniversity("코틀린")
//
//        inhaGongjeonUniversity.bookDtoList.forEach { println("가져온 책 ${it.title}") }
//
//    }
//
//
//    @Test
//    @DisplayName("용인도서관 검색")
//    fun yonginLibrary() {
//        val yonginLibrary = librarySearchService.yonginLibrary("디버깅")
//
//        yonginLibrary.bookDtoList.forEach { println("가져온 책 ${it.title}") }
//        println("총값 =  ${yonginLibrary.bookSearchTotalCount}")
//
//    }
//
//
//    @Test
//    @DisplayName("전체도서관검색")
//    fun allSearch() = runBlocking {
//        val allSearchResult = librarySearchService.allLibraryAsync("코틀린")
//        allSearchResult.librarySearchServiceResponseList.forEach { it.bookDtoList.forEach { println("조회한 책 = ${it.title}") } }
//
//    }
//
//
//
//
//
//
//
//}