package com.example.entity

import com.example.domain.BookInterestStatus
import com.example.domain.LibraryType
import jakarta.persistence.*
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "BOOK_INTEREST")
class BookInterestEntity(
    id: String,
    libraryType: LibraryType,
    title: String,
    userId: String,
    explanation: String,
    status: BookInterestStatus,
    createdDateTime: LocalDateTime,
    updatedDateTime: LocalDateTime? = null,
) {

    @Id
    @Column(name = "ID")
    var id: String = id
        protected set

    @Column(name = "USER_ID" , nullable = false)
    var userId: String = userId
        protected set

    @Column(name = "LIBRARY_TYPE" , nullable = false)
    @Enumerated(value = EnumType.STRING)
    var libraryType: LibraryType = libraryType
        protected set

    @Column(name = "TITLE" , nullable = false)
    var title: String = title
        protected set

    @Column(name = "EXPLANATION")
    var explanation: String = explanation
        protected set

    @Column(name = "STATUS" , nullable = false)
    @Enumerated(value = EnumType.STRING)
    var status: BookInterestStatus = status
        protected set

    @Column(name = "CREATED_DATE_TIME" , nullable = false)
    var createdDateTime: LocalDateTime = createdDateTime
        protected set

    @Column(name = "UPDATED_DATE_TIME")
    var updatedDateTime: LocalDateTime? = updatedDateTime
        protected set

}
