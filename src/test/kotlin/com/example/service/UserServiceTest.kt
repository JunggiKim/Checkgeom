//package com.example.service
//
//import io.kotest.matchers.shouldBe
//
//
//
//class UserServiceImplTest(
//    private val userService: UserService,
//) : StringIntegrationTest() {
//
//
//    init {
//         "회원가입을_한다" {
//            val userId = "kjg"
//            userService.signup(userId)
//        }
//
//         "로그인을_성공_한다" {
//            val result = userService.login("kjg")
//            result shouldBe true
//        }
//
//        "로그인을_실패_한다" {
//            val result = userService.login("999")
//            result shouldBe false
//        }
//
//
//    }
//
//}
//
