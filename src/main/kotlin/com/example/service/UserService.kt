package com.example.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface UserService {
    fun login(userId: String): Boolean
    fun signup(userId: String)

}

@Service
@Transactional
class UserServiceImpl(
    private val userServiceReader: UserServiceReader,
    private val userServiceWriter: UserServiceWriter

) : UserService {

    override fun login(userId: String): Boolean {
        return userServiceReader.duplicateUserCheck(userId)
    }

    override fun signup(userId: String) {
        userServiceReader.duplicateUserValidation(userId)

        val createUser = userServiceWriter.createUser(userId)

        userServiceWriter.userSignup(createUser)
    }

}