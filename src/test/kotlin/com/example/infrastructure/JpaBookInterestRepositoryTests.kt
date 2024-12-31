//package com.example.infrastructure
//
//import com.example.domain.BookInterestStatus
//import com.example.domain.LibraryType
//import com.example.infrastructur.BookInterestRepository
//import com.example.infrastructure.dto.request.SaveBookInterestInfrastructureRequest
//import io.kotest.core.spec.style.FunSpec
//import io.kotest.matchers.shouldBe
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//import java.time.LocalDateTime
//import java.util.*
//
//
//@SpringBootTest
//@ActiveProfiles("test")
//class JpaBookInterestRepositoryTests(
//    val bookInterestRepository: BookInterestRepository
//) : FunSpec({
//
//    test("유저 아이디로 현재등록환 삭제되지 않은 관심도서들을 가져온다.") {
//
//
//        val createSaveRequest = createSaveRequest()
//
//        bookInterestRepository.bookInterestSave(createSaveRequest)
//
//
//        val result = bookInterestRepository.findByUserIdBookInterestList("kjg")
//
////        result.size shouldBe 4
//        println("결과 = $result")
//
//    }
//
//    test("findBookInterest") { }
//
//    test("bookInterestSave") { }
//
//    test("bookInterestModify") { }
//
//
//    test("bookInterestModify") {
//
//    }
//})
//
//private fun createSaveRequest()  : SaveBookInterestInfrastructureRequest{
//    return SaveBookInterestInfrastructureRequest.of(
//        id = UUID.randomUUID(),
//        userId = "kjg",
//        title = "test",
//        libraryType = LibraryType.ETC,
//        explanation = "test",
//        status = BookInterestStatus.AFTER_READING,
//        createdDateTime = LocalDateTime.now()
//
//    )
//}
