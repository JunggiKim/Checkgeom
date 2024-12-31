package com.example.infrastructur

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import com.example.entity.BookInterestEntity
import com.example.infrastructure.dto.InfrastructureBookInterestDto
import com.example.infrastructure.dto.request.ModifyBookInterestInfraRequest
import com.example.infrastructure.dto.request.SaveBookInterestInfraRequest
import com.example.infrastructure.dto.response.FindBookInterestInfraResponse
import com.example.infrastructure.dto.response.ModifyBookInterestInfraResponse
import com.example.infrastructure.jpa.BookInterestJpaRepository
import jooq.tables.BookInterest.Companion.BOOK_INTEREST
import org.jooq.DSLContext
import org.jooq.User
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import java.util.UUID


interface BookInterestRepository {

    fun findByUserIdBookInterestList(userId: String): MutableList<FindBookInterestInfraResponse>

    fun findBookInterest(id: String): InfrastructureBookInterestDto

    fun bookInterestSave(request: SaveBookInterestInfraRequest)

    fun bookInterestModify(request: ModifyBookInterestInfraRequest): ModifyBookInterestInfraResponse
}


@Repository
class JpaBookInterestRepository(
    private val bookInterestJpaRepository: BookInterestJpaRepository,
    private val dsl: DSLContext
) : BookInterestRepository {

    override fun findByUserIdBookInterestList(userId: String): MutableList<FindBookInterestInfraResponse> {

        return dsl.select(
            BOOK_INTEREST.ID ,
            BOOK_INTEREST.USER_ID ,
            BOOK_INTEREST.TITLE ,
            BOOK_INTEREST.LIBRARY_TYPE ,
            BOOK_INTEREST.EXPLANATION ,
        )
            .from(BOOK_INTEREST)
            .where(
                BOOK_INTEREST.USER_ID.eq(userId)
                    .and(BOOK_INTEREST.STATUS.ne(BookInterestStatus.DELETED.name))
            )
            .fetchInto(FindBookInterestInfraResponse::class.java)
    }


    override fun findBookInterest(id: String): InfrastructureBookInterestDto {

        val findEntity = bookInterestJpaRepository.findById(id)
            .orElseThrow { throw IllegalArgumentException("존재하지 않는 도서 입니다.") }


        return InfrastructureBookInterestDto(
            id = UUID.fromString(findEntity.id),
            userId = findEntity.userId,
            title = findEntity.title,
            libraryType = findEntity.libraryType,
            explanation = findEntity.explanation,
            status = findEntity.status,
            createdDateTime = findEntity.createdDateTime,
            updatedDateTime = findEntity.updatedDateTime
        )

    }

    override fun bookInterestSave(request: SaveBookInterestInfraRequest) {

        val entity = BookInterestEntity(
            id = request.id.toString(),
            libraryType = request.libraryType,
            title = request.title,
            userId = request.userId,
            explanation = request.explanation,
            status = request.status,
            createdDateTime = request.createdDateTime,
        )

        bookInterestJpaRepository.save(entity)
    }


    override fun bookInterestModify(request: ModifyBookInterestInfraRequest): ModifyBookInterestInfraResponse {

        println("가져온 것 =  $request")

        val savedEntity = bookInterestJpaRepository.save(request.toEntity())

        return ModifyBookInterestInfraResponse.of(
            id = UUID.fromString(savedEntity.id),
            userId = savedEntity.userId,
            title = savedEntity.title,
            libraryType = savedEntity.libraryType,
            explanation = savedEntity.explanation,
            status = savedEntity.status,
            createdDateTime = savedEntity.createdDateTime,
            updatedDateTime = savedEntity.updatedDateTime!!,
        )
    }


//    fun findActiveBooksByUserId(userId: String): List<BookInterestEntity> {
//
//    }

}


//@Repository
//class RedisBookInterestRepositoryImpl(
//    private val redisTemplate: RedisTemplate<String, Any>
//) : BookInterestRepository {
//
//    override fun getBookInterestList(userId: String): MutableList<BookInterest> {
//        val bookInterests = redisTemplate.opsForValue().get(userId) as? MutableList<BookInterest>
//        return bookInterests ?: mutableListOf()
//    }
//
//
//    override fun addBookInteresList(userId: String, requestBookInterestList: List<BookInterest>) {
//        val afterBookInterestList = createIdEntity(requestBookInterestList)
//
//        val beforeBookInterest: MutableList<BookInterest> = getBookInterestList(userId)
//        beforeBookInterest.addAll(afterBookInterestList)
//        // 생각해보니까 추가해주는 책 목록만 받아서 추가해주면되는데 이전것의 값들까지 전부추가해주니까 그런거같은데
////        val uniqueBookInterestList = beforeBookInterest.distinctBy { it.id }
//        redisTemplate.opsForValue().set(userId, beforeBookInterest)
//    }
//
//    private fun createIdEntity(requestBookInterestList: List<BookInterest>) =
//        requestBookInterestList.map {
//            if (it.id.isNullOrBlank()) {
//                BookInterest(
//                    id = UlidCreator.getMonotonicUlid().toString(),
//                    title = it.title,
//                    libraryType = it.libraryType,
//                    explanation = it.explanation,
//                )
//            } else {
//                it
//            }
//        }
//
//    override fun deleteBookInteresList(userId: String, afterBookInterests: List<BookInterest>) {
//        val beforeBookInterestList = getBookInterestList(userId)
//
//        val filterList = beforeBookInterestList.filter { beforeBookInterest ->
//            afterBookInterests.none { it.id == beforeBookInterest.id }
//        }
//
//        redisTemplate.opsForValue().set(userId, filterList)
//    }
//
//
//    override fun modifyBookInteresList(userId: String, bookInterests: List<BookInterest>) {
//        val beforeBookInterests = getBookInterestList(userId)
//
//        val updatedBookInterests = beforeBookInterests.map { before ->
//            bookInterests.find { it.id == before.id } ?: before
//
//        }
//
//        redisTemplate.opsForValue().set(userId, updatedBookInterests)
//    }
//
//
//}





