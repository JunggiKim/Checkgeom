package com.example.infrastructure.jpa

import com.example.entity.BookInterestEntity
import com.example.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BookInterestJpaRepository : JpaRepository<BookInterestEntity, String>{

    fun findAllByUserId(userId: String): List<BookInterestEntity>

}

interface UserJpaRepository : JpaRepository<UserEntity, String>{
    fun findByUserId(userId: String): UserEntity?

}
