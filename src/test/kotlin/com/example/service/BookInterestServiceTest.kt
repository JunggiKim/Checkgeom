//package com.example.service
//
//import com.example.domain.BookInterest
//import com.example.domain.LibraryType
//import com.example.persistence.BookInterestRepository
//import com.example.service.dto.request.ServiceRequestModifyBookInterest
//import com.example.service.dto.request.ServiceRequestSaveBookInterest
//import io.kotest.assertions.throwables.shouldThrow
//import io.kotest.core.spec.style.FunSpec
//import io.kotest.matchers.shouldBe
//import io.mockk.every
//import io.mockk.mockk
//import io.mockk.verify
//import java.util.*
//
//class BookInterestServiceTest() : StringIntegrationTest() {
//
//    init {
//
//        // Mockk로 BookInterestRepository 생성
//        val bookInterestRepository = mockk<BookInterestRepository>(relaxed = true)
//        val bookInterestService = BookInterestServiceImpl(bookInterestRepository)
//
//        // 책을 정상적으로 추가하는 테스트
//        "책을 정상적으로 추가한다" {
//            // given
//            val request = ServiceRequestSaveBookInterest(
//                userId = "user1",
//                title = "Test Book",
//                libraryType = LibraryType.ALL,
//                explanation = "A test book"
//            )
//
//            // when
//            bookInterestService.bookInterestAdd(request)
//
//            // then
//            verify { bookInterestRepository.addBookInterest(any()) }  // 호출된 메서드 확인
//        }
//
//        // 책 정보를 정상적으로 수정하는 테스트
//        "책 정보를 정상적으로 수정한다"{
//            // given
//            val request = ServiceRequestModifyBookInterest(
//                id = UUID.randomUUID(),
//                title = "Updated Title",
//                libraryType = LibraryType.ALL,
//                explanation = "Updated Explanation"
//            )
//
//            val existingBookInterest = BookInterest.create(
//                id = request.id,
//                userId = "user1",
//                title = "Old Title",
//                libraryType = LibraryType.ALL,
//                explanation = "Old Explanation"
//            )
//
//            // Mock repository
//            every { bookInterestRepository.findBookInterest(request.id) } returns existingBookInterest
//            every { bookInterestRepository.modifyBookInterest(any()) } returns existingBookInterest.copy(
//                title = request.title,
//                libraryType = request.libraryType,
//                explanation = request.explanation
//            )
//
//            // when
//            val modifiedBookInterest = bookInterestService.bookInterestModify(request)
//
//            // then
//            modifiedBookInterest.title shouldBe "Updated Title"
//            modifiedBookInterest.libraryType shouldBe LibraryType.ALL
//            modifiedBookInterest.explanation shouldBe "Updated Explanation"
//        }
//
//        // 책을 정상적으로 삭제하는 테스트
//        "책을 정상적으로 삭제한다"{
//            // given
//            val bookInterestId = UUID.randomUUID()
//            val bookInterest = BookInterest.create(
//                id = bookInterestId,
//                userId = "user1",
//                title = "Test Book",
//                libraryType = LibraryType.ALL,
//                explanation = "Test Explanation"
//            )
//
//            // Mock repository
//            every { bookInterestRepository.findBookInterest(bookInterestId) } returns bookInterest
//            every { bookInterestRepository.modifyBookInterest(any()) } returns bookInterest.copy(status = BookInterest.Status.DELETED)
//
//            // when
//            bookInterestService.bookInterestDelete(bookInterestId)
//
//            // then
//            verify { bookInterestRepository.modifyBookInterest(any()) }  // modifyBookInterest 호출 확인
//        }
//
//        // 예외 처리 테스트 (빈 제목으로 책을 추가하려고 시도)
//        "빈 제목으로 책을 추가하려고 하면 예외가 발생한다"{
//            // given
//            val request = ServiceRequestSaveBookInterest(
//                userId = "user1",
//                title = "",  // 빈 제목
//                libraryType = LibraryType.ALL,
//                explanation = "A test book"
//            )
//
//            // then
//            shouldThrow<IllegalArgumentException> {
//                bookInterestService.bookInterestAdd(request)
//            }
//        }
//    }
//
//}
