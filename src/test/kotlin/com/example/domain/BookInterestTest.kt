//package com.example.domain
//
//import com.example.util.getUuid
//import io.kotest.assertions.throwables.shouldThrow
//import io.kotest.core.spec.style.FunSpec
//import io.kotest.matchers.shouldBe
//import java.time.LocalDateTime
//import java.util.UUID
//
//class BookInterestTest : FunSpec({
//
//    test("정상적인 값으로 관심 도서를 생성한다.") {
//        // given
//        val id = getUuid()
//        val userId = "user1"
//        val title = "Test Book"
//        val libraryType = LibraryType.ALL
//        val explanation = "A test book"
//
//        // when
//        val bookInterest = BookInterest.create(
//            id = id,
//            userId = userId,
//            title = title,
//            libraryType = libraryType,
//            explanation = explanation
//        )
//
//        // then
//        bookInterest.id shouldBe id
//        bookInterest.title shouldBe title
//        bookInterest.libraryType shouldBe libraryType
//        bookInterest.explanation shouldBe explanation
//        LocalDateTime.now().isAfter(bookInterest.createdDateTime) shouldBe true
//        bookInterest.updatedDateTime shouldBe null
//    }
//
//    test("제목을 빈값으로 관심 도서를 생성하면 익셉션이 발생한다.") {
//        // given
//        val id = getUuid()
//        val userId = "user1"
//        val title = ""
//        val libraryType = LibraryType.ALL
//        val explanation = "A test book"
//
//        // then
//        shouldThrow<IllegalArgumentException> {
//            BookInterest.create(
//                id = id,
//                userId = userId,
//                title = title,
//                libraryType = libraryType,
//                explanation = explanation
//            )
//        }
//    }
//    test("유저를 빈값으로 관심 도서를 생성하면 익셉션이 발생한다.") {
//        // given
//        val id = getUuid()
//        val userId = ""
//        val title = ""
//        val libraryType = LibraryType.ALL
//        val explanation = "A test book"
//
//        // then
//        shouldThrow<IllegalArgumentException> {
//            BookInterest.create(
//                id = id,
//                userId = userId,
//                title = title,
//                libraryType = libraryType,
//                explanation = explanation
//            )
//        }
//    }
//
//    test("생성한 책을 정상적인 값으로 수정을 한다.") {
//        // given
//
//        val newTitle = "New Title"
//        val newLibraryType = LibraryType.ALL
//        val newExplanation = "New Explanation"
//
//
//        val bookInterest = BookInterest.modify(
//            id = getUuid(),
//            userId = "user1",
//            title = newTitle,
//            libraryType = newLibraryType,
//            explanation = newExplanation,
//            createdDateTime = LocalDateTime.now(),
//            status = BookInterestStatus.BEFORE_READING,
//            updatedDateTime = LocalDateTime.now(),
//        )
//
//
//    }
//
//
//    test("생성한 책을 제목을 빈 값으로 수정을 한다.") {
//        // given
//        val bookInterest = BookInterest.modify(
//            id = ,
//                    userId = ,
//                    title = ,
//                    libraryType = ,
//                    explanation = ,
//                    createdDateTime = ,
//                    status = ,
//                    updatedDateTime = ,
//        )
//        val newTitle = ""
//        val newLibraryType = LibraryType.ALL
//        val newExplanation = "New Explanation"
//
//        // when
//        shouldThrow<IllegalArgumentException> {
//            bookInterest.modify(
//                title = newTitle,
//                libraryType = newLibraryType,
//                explanation = newExplanation
//            )
//        }
//    }
//
//    test("정상적인 도서를 삭제한다.") {
//        // given
//        val bookInterest = BookInterest.create(
//            id = getUuid(),
//            userId = "user1",
//            title = "Book To Delete",
//            libraryType = LibraryType.ALL,
//            explanation = "Explanation"
//        )
//
//        // when
//        val deletedBookInterest = bookInterest.delete()
//
//        // then
//        deletedBookInterest.status shouldBe BookInterestStatus.DELETED
//    }
//    test("이미 삭제 처리 된 도서를 삭제한다.") {
//        // given
//        val bookInterest = BookInterest.create(
//            id = getUuid(),
//            userId = "user1",
//            title = "Book To Delete",
//            libraryType = LibraryType.ALL,
//            explanation = "Explanation"
//        )
//
//        // when
//        val deletedBookInterest = bookInterest.delete()
//
//        // then
//
//        shouldThrow<IllegalArgumentException> {
//            deletedBookInterest.delete()
//        }
//    }
//})
