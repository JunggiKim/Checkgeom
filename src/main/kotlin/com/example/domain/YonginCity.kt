package com.example.domain

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

object YonginCity {

    private const val BASIC_SEARCH_URL =
        "https://lib.yongin.go.kr/giheung/menu/10758/program/30012/plusSearchResultList.do"

    private const val GIHEUNG_LIBRARY_SEARCH_URL =
        "https://lib.yongin.go.kr/giheung/menu/10759/program/30013/plusSearchResultList.do?"

    private const val MORE_VIEW_COUNT = "&rowCount="

    fun basicSearchUrlCreate() = BASIC_SEARCH_URL


//    fun giheungLibrarySearchUrlCreate(queryParams: Map<String,String>) =
//
//        """
//        ${GIHEUNG_LIBRARY_SEARCH_URL}+$queryParams["]
//        """.trimIndent()

    fun bodyCreate2(searchKeyword: String) : MultiValueMap<String,String> {

        val map: MultiValueMap<String, String> = LinkedMultiValueMap()

        map.add("searchKeyword" , searchKeyword)
        map.add("searchCategory" , "BOOK")
        map.add("searchKey" , "ALL")
        map.add("searchLibraryArr" , "MK")
        map.add("searchType" , "SIMPLE")

        return map
    }


    fun bodyCreate(searchKeyword: String) : MultiValueMap<String,String> {

        val map: MultiValueMap<String, String> = LinkedMultiValueMap()

        map.add("searchType","SIMPLE")
        map.add("searchMenuCollectionCategory","")
        map.add("searchMenuEBookCategory","")
        map.add("searchMenuEBook2Category","")
        map.add("searchCategory","BOOK")
        map.add("searchKey1","")
        map.add("searchKey2","")
        map.add("searchKey3","")
        map.add("searchKey4","")
        map.add("searchKey5","")
        map.add("searchKeyword1","")
        map.add("searchKeyword2","")
        map.add("searchKeyword3","")
        map.add("searchKeyword4","")
        map.add("searchKeyword5","")
        map.add("searchOperator1","")
        map.add("searchOperator2","")
        map.add("searchOperator3","")
        map.add("searchOperator4","")
        map.add("searchOperator5","")
        map.add("searchPublishStartYear","")
        map.add("searchPublishEndYear","")
        map.add("searchRoom","")
        map.add("searchKdc","")
        map.add("searchIsbn","")
        map.add("currentPageNo","1")
        map.add("viewStatus","TEXT")
        map.add("preSearchKey","ALL")
        map.add("preSearchKeyword","")
        map.add("searchKey","ALL")
        map.add("searchKeyword",searchKeyword)
        map.add("searchTotalPbLibrary","ALL")
        map.add("searchPbLibrary","ALL")
        map.add("searchLibraryArr","MA")
        map.add("searchLibraryArr","MI")
        map.add("searchLibraryArr","MD")
        map.add("searchLibraryArr","MK")
        map.add("searchLibraryArr","MY")
        map.add("searchLibraryArr","MF")
        map.add("searchLibraryArr","NA")
        map.add("searchLibraryArr","ML")
        map.add("searchLibraryArr","MM")
        map.add("searchLibraryArr","MO")
        map.add("searchLibraryArr","MZ")
        map.add("searchLibraryArr","NB")
        map.add("searchLibraryArr","MB")
        map.add("searchLibraryArr","MJ")
        map.add("searchLibraryArr","NN")
        map.add("searchLibraryArr","MX")
        map.add("searchLibraryArr","ME")
        map.add("searchLibraryArr","MP")
        map.add("searchLibraryArr","MC")
        map.add("searchLibraryArr","MN")
        map.add("searchStLibrary","ALL")
        map.add("searchLibraryArr","NO")
        map.add("searchLibraryArr","NJ")
        map.add("searchLibraryArr","NF")
        map.add("searchLibraryArr","NG")
        map.add("searchLibraryArr","NP")
        map.add("searchLibraryArr","NH")
        map.add("searchLibraryArr","NI")
        map.add("searchLibraryArr","NL")
        map.add("searchLibraryArr","NM")
        map.add("searchLibraryArr","NQ")
        map.add("searchLibraryArr","ND")
        map.add("searchLibraryArr","NK")
        map.add("searchSmLibrary","ALL")
        map.add("searchLibraryArr","NC")
        map.add("searchLibraryArr","MS")
        map.add("searchLibraryArr","MT")
        map.add("searchLibraryArr","MW")
        map.add("searchLibraryArr","MQ")
        map.add("searchLibraryArr","MV")
        map.add("searchSort","PUBLISHYEAR")
        map.add("searchOrder","DESC")
        map.add("searchRecordCount","10")

        return map
    }


    fun moreViewSearchUrlCreate(basicUrl: String?, totalCount: Int): String {
        return StringBuilder().append(basicUrl)
            .append(MORE_VIEW_COUNT).append(totalCount)
            .toString()
    }

}