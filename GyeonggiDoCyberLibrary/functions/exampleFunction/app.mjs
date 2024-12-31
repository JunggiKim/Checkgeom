import chromium from '@sparticuz/chromium';
import puppeteer from 'puppeteer-core';
import GyeonggiDoCyberLibraryReader from './GyeonggiDoCyberLibraryReader.js';


export const lambdaHandler = async (event, context) => {
    const browser = await puppeteer.launch({
        args: chromium.args,
        defaultViewport: chromium.defaultViewport,
        executablePath: await chromium.executablePath(),
        headless: chromium.headless,
    });


    const libraryReader = new GyeonggiDoCyberLibraryReader(); // 클래스 인스턴스 생성
    const searchKeyword = event.queryStringParameters?.searchKeyword;
    const searchUrl = `https://ebook.library.kr/search?listType=list&keyword=${searchKeyword}&searchType=all`


    console.log('searchKeyword = ', searchKeyword)
    console.log('searchURL = ', searchUrl)

    const page = await browser.newPage();
    await page.goto(searchUrl, {waitUntil: 'networkidle2'});

    // 책들 row 값 가져오는 부분에서 검색결과가 없다면 에러가나니까 다른 값으로 변경해서 해보자
    // await page.waitForSelector('li.bookItem.row', {timeout: 30000});
    await page.waitForSelector('div.searchResult', {timeout: 30000});

    const bookList = await libraryReader.searchBookList(page);
    // 총 도서 수 검색
    const bookSearchTotalCount = await libraryReader.getBookSearchTotalCount(page);
    // 더보기 링크 검색
    const moreViewLink = await libraryReader.getMoreViewLinks(page, searchKeyword);

    await page.close();
    await browser.close();

    return {
        statusCode: 200,
        headers: {
            "Content-Type": "application/json",
            'Access-Control-Allow-Origin': '*',  // 모든 출처 허용
            'Access-Control-Allow-Methods': 'GET, OPTIONS',  // GET과 OPTIONS 메서드 허용
            'Access-Control-Allow-Headers': 'Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token',  // 필요한 헤더 허용
        },
        body: JSON.stringify({
                bookDtoList: bookList,
                bookSearchTotalCount: bookSearchTotalCount,
                moreViewLink: moreViewLink,
                libraryTypeText: '경기도사이버도서관',
                statusCode: 200,
                statusCodeValue: "OK",
            }
        )
    };

};
