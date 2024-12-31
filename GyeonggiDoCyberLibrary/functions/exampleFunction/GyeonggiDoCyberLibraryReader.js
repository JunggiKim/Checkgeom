
class GyeonggiDoCyberLibraryReader {

    async searchBookList(page) {
        // 페이지에서 book list 정보를 가져옴
        return page.evaluate(() => {
            const getBookImageLink = (bookElement) => bookElement.querySelector('img.bookCover').src;
            const getBookTitle = (bookElement) => bookElement.querySelector('h6.title').textContent.trim();
            const getBookPublishingInformationList = (bookElement) =>
                bookElement.querySelector('p.desc').textContent.split('/').map(info => info.trim());
            const getLoanReservationStatus = (bookElement) => bookElement.querySelector('div.stat').textContent.trim();

            return Array.from(document.querySelectorAll('li.bookItem.row')).map(bookElement => ({
                image: getBookImageLink(bookElement),
                title: getBookTitle(bookElement),
                author: getBookPublishingInformationList(bookElement)[0],
                publisher: getBookPublishingInformationList(bookElement)[1],
                publishDate: getBookPublishingInformationList(bookElement)[2],
                loanStatus: getLoanReservationStatus(bookElement)
            }));
        });
    }

    async getGyeonggiDoCyberLibraryHtmlBody(page, searchKeyword) {
        const basicSearchUrl = `https://ebook.library.kr/search?listType=list&keyword=${searchKeyword}&searchType=all`;
        console.log(basicSearchUrl)
        await page.goto(basicSearchUrl);
        await page.waitForSelector('li.bookItem.row'); // 로딩 대기
        return await page.content();
    }

    async getMoreViewLinks(page, searchKeyword) {
        const moreViewList = await this.isMoreViewList(page);
        if (moreViewList.some(view => view.isMoreView)) {
            return moreViewList.map(viewType => moreViewSearchUrlCreate(searchKeyword, viewType));
        }
        return [];
    }

    async isMoreViewList(page) {
        return page.evaluate(() => {
            const mapGyeonggiDoCyberLibraryMoreViewType = (element) => {
                const childText = element.childNodes[0].textContent;
                const totalCount = childText.replace(/[^0-9]/g, '');
                const bookTypeText = childText.includes('(') ? childText.split('(')[0].trim() : childText;
                if (bookTypeText === '오디오북') return null;

                return {bookType: bookTypeText, moreViewTotalCount: parseInt(totalCount, 10), isMoreView: true};
            }

            return Array.from(document.querySelectorAll('h5.searchH'))
                .filter(element => !element.textContent.includes('오디오북'))
                .map(element => mapGyeonggiDoCyberLibraryMoreViewType(element));
        });
    }

    async getBookSearchTotalCount(page) {
        const totalCountText = await page.evaluate(() => {
            return document.querySelector('h4.summaryHeading i').textContent.replace(",", "");
        });
        return parseInt(totalCountText, 10);
    }
}

// Helper functions for data extraction (static)
function getBookImageLink(bookElement) {
    return bookElement.querySelector('img.bookCover').src;
}

function getBookTitle(bookElement) {
    return bookElement.querySelector('h6.title').textContent.trim();
}

function getBookPublishingInformationList(bookElement) {
    return bookElement.querySelector('p.desc').textContent.split('/').map(info => info.trim());
}

function getLoanReservationStatus(bookElement) {
    return bookElement.querySelector('div.stat').textContent.trim();
}

function mapGyeonggiDoCyberLibraryMoreViewType(element) {
    const childText = element.childNodes[0].textContent;
    const totalCount = childText.replace(/[^0-9]/g, '');
    const bookTypeText = childText.includes('(') ? childText.split('(')[0].trim() : childText;

    if (bookTypeText === '오디오북') return null;

    return {bookType: bookTypeText, moreViewTotalCount: parseInt(totalCount, 10)};
}


function moreViewSearchUrlCreate(keyword, viewType) {
    const BASIC_SEARCH_URL = 'https://ebook.library.kr/search/type?searchType=all&listType=list&asc=desc&keyword='; // 기본 URL
    const CONTENT_TYPE_URL = '&contentType='; // 콘텐츠 타입 URL 부분
    const SIZE = '&size='; // 사이즈 URL 부분

    return `${BASIC_SEARCH_URL}${encodeURIComponent(keyword)}${CONTENT_TYPE_URL}${viewType ? encodeURIComponent(viewType.bookType.urlType) : ''}${SIZE}${viewType ? viewType.totalCount : ''}`;
}


export default GyeonggiDoCyberLibraryReader;


