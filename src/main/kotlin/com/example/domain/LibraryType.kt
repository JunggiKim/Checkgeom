package com.example.domain


enum class LibraryType(
    val englishText: String,
    val koreanText: String
) {
    ALL("all", "전체"),
    GYEONGGIDO_CYBER("gyeonggiDoCyberLibrary", "경기도 사이버 전자 도서관"),
    GYEONGGI_EDUCATIONAL("gyeonggiEducationalElectronic", "경기도 교육 전자 도서관"),
    SMALL_BUSINESS("smallBusiness", "소상공인 전자 도서관"),
    HONGIK_UNIVERSITY("hongikUniversity", "홍익대학교 전자 도서관"),
    INHAGONGJEON_UNIVERSITY("inhagongjeonUniversity", "인하공전대학교 전자 도서관"),
    YONGIN_CITY("yonginCity", "용인시 도서관"),
    KYOBO_BOOKSTORE("kyoboBookstore", "교보문고"),
    YES_24("yes24", "예스24"),
    ETC("etc", "기타");

    companion object {
        fun fromEnglishText(englishText: String): LibraryType {
            return entries.find { it.englishText.equals(englishText, ignoreCase = true) }
                ?: throw IllegalArgumentException("올바른 English LibraryType 값이 아닙니다. :$englishText")
        }

        // 한글 텍스트로 LibraryType을 찾는 함수
        fun fromKoreanText(koreanText: String): LibraryType {
            return entries.find { it.koreanText.equals(koreanText, ignoreCase = true) }
                ?: throw IllegalArgumentException("올바른 Korean LibraryType 값이 아닙니다. :$koreanText")
        }
    }
}

