//package com.example.service
//
//import com.example.domain.LibraryType
//import com.example.infrastructur.BookInterestRepository
//import com.example.service.dto.request.ModifyBookInterestServiceRequest
//import com.example.service.dto.request.SaveBookInterestServiceRequest
//import io.kotest.matchers.shouldBe
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//import java.util.*
//
//@SpringBootTest
//@ActiveProfiles("test")
//final class BookInterestIntegrationServiceTest(
//    private val bookInterestRepository: BookInterestRepository,
//    private val bookInterestService: BookInterestService
//) : FunIntegrationTest() {
//
//
//    init {
//
//        // 책을 정상적으로 추가하는 테스트
//        test("책을 정상적으로 추가한다") {
//            // given
//            val request = SaveBookInterestServiceRequest(
//                userId = "user1",
//                title = "Test Book",
//                libraryType = LibraryType.ALL,
//                explanation = "A test book"
//            )
//
//            // when
//            bookInterestService.bookInterestSave(request)
//
//            // then
//
//        }
//
//        // 책 정보를 정상적으로 수정하는 테스트
//        test("책 정보를 정상적으로 수정한다")
//        {
//            // given
//            val request = ModifyBookInterestServiceRequest(
//                title = "Updated Title",
//                id = UUID.fromString("0193f6c1-9799-f8ea-e9f4-8f10c17005f6"),
//                libraryType = LibraryType.ALL,
//                explanation = "Updated Explanation"
//            )
//
//
//            // when
//            val modifiedBookInterest = bookInterestService.bookInterestModify(request)
//
//            // then
//            modifiedBookInterest.title shouldBe request.title
//            modifiedBookInterest.libraryType shouldBe request.libraryType
//            modifiedBookInterest.explanation shouldBe request.explanation
//        }
//
//
//        // 책을 정상적으로 삭제하는 테스트
//        test("책을 정상적으로 삭제한다")
//        {
//            // given
//
//            val bookInterestId = UUID.fromString("0193f6c1-9799-f8ea-e9f4-8f10c17005f6")
//
//            // when
//            bookInterestService.bookInterestDelete(bookInterestId)
//
//        }
//
//
//        test("책 정보를 가져온다.")
//        {
//            // given
//
//            val bookInterestId = UUID.fromString("0193f6c1-9799-f8ea-e9f4-8f10c17005f6")
//
//            // when
//            bookInterestService.findBookInterestList("user1")
//                .forEach { println("가져왔음 =  $it") }
//
//        }
//
//    }
//
//
//}
