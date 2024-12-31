package com.example.domain


object HongikUniversity {

    private const val BASIC_SEARCH_URL =
        "https://ebook.hongik.ac.kr/elibrary-front/search/searchList.ink?schClst=all&schDvsn=000&orderByKey=&schTxt="
    private const val BASIC_MORE_VIEW_SEARCH_URL =
        "https://ebook.hongik.ac.kr/elibrary-front/search/searchList.ink?brcd=&sntnAuthCode=&contentAll=&" +
                "cttsDvsnCode=&orderByKey=&schClst=all&schDvsn=000&reSch=&ctgrId=&allClstCheck=on&clstCheck=ctts&clstCheck=autr&clstCheck=pbcm&clstCheck=intc_cntt&allDvsnCheck=000&dvsnCheck=001&reSchTxt=&pageIndex=1&recordCount=20"
    fun basicSearchUrlCreate(searchKeyword: String?): String {
        return BASIC_SEARCH_URL + (searchKeyword ?: "")
    }
    fun moreViewSearchUrlCreate(searchKeyword: String , totalCount : Int): String {
        return "$BASIC_MORE_VIEW_SEARCH_URL&schTxt=$searchKeyword&selViewCnt=$totalCount"
    }

    fun decisionOnWhetherLoanReservationIsPossible(
        currentNumberOfLoans: Int,
        totalNumberOfLoansPossible: Int,
        ): String {
        return when {
            currentNumberOfLoans < totalNumberOfLoansPossible -> "대출 가능"
            else -> "예약 가능"
        }

    }

}