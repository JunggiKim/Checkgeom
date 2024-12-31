package com.example.domain

object GyeonggiEducation {

    private const val BASIC_SEARCH_URL =
        "https://lib.goe.go.kr/elib/module/elib/search/index.do?com_code=&menu_idx=94&viewPage=1&type=&search_text="

    private const val MORE_VIEW_COUNT = "&rowCount="


    fun basicSearchUrlCreate(searchKeyword: String?): String {
        return StringBuilder(BASIC_SEARCH_URL).append(searchKeyword)
            .toString()
    }

    fun moreViewSearchUrlCreate(basicUrl: String?, totalCount: Int): String {
        return StringBuilder().append(basicUrl)
            .append(MORE_VIEW_COUNT).append(totalCount)
            .toString()
    }
}
