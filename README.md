서비스 URL : http://www.checkgeom.com

<div align="center">

<!-- logo -->
<img src="https://user-images.githubusercontent.com/80824750/208554611-f8277015-12e8-48d2-b2cc-d09d67f03c02.png" width="400"/>

### Back-end Git Reamd.me Template ✅

[<img src="https://img.shields.io/badge/-readme.md-important?style=flat&logo=google-chrome&logoColor=white" />]() [<img src="https://img.shields.io/badge/-tech blog-blue?style=flat&logo=google-chrome&logoColor=white" />]() [<img src="https://img.shields.io/badge/release-v0.0.0-yellow?style=flat&logo=google-chrome&logoColor=white" />]() 
</div> 



다음과 같은 내용을 작성할 수 있습니다.
- 프로젝트 소개
- 프로젝트 화면 구성 또는 프로토 타입
- 프로젝트 API 설계
- 사용한 기술 스택
- 프로젝트 아키텍쳐
- 기술적 이슈와 해결 과정
- 프로젝트 팀원

필요한 기술 스택에 대한 logo는 [skills 폴더](/skills/)에서 다운로드 받을 수 있습니다.

<br />

> 화면 구성과 프로토 타입 중 원하는 것을 사용해주세요.

### 화면 구성
|Screen #1|Screen #2|
|:---:|:---:|
|<img src="https://user-images.githubusercontent.com/80824750/208456048-acbf44a8-cd71-4132-b35a-500047adbe1c.gif" width="400"/>|<img src="https://user-images.githubusercontent.com/80824750/208456234-fb5fe434-aa65-4d7a-b955-89098d5bbe0b.gif" width="400"/>|

### 프로토타입
<img src="https://user-images.githubusercontent.com/80824750/208454673-0449e49c-57c6-4a6b-86cf-66c5b1e623dc.png">

<br />

## 🗂️ APIs
작성한 API는 아래에서 확인할 수 있습니다.

👉🏻 [API 바로보기](/backend/APIs.md)


<br />

## ⚙ 기술 스택
> skills 폴더에 있는 아이콘을 이용할 수 있습니다.
### Back-end
<div>
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Java.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/SpringBoot.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/SpringSecurity.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/SpringDataJPA.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Mysql.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Ajax.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Thymeleaf.png?raw=true" width="80">
</div>

### Infra
<div>
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/AWSEC2.png?raw=true" width="80">
</div>

### Tools
<div>
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Github.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Notion.png?raw=true" width="80">
</div>

<br />

## 🛠️ 프로젝트 아키텍쳐
![no-image](https://user-images.githubusercontent.com/80824750/208294567-738dd273-e137-4bbf-8307-aff64258fe03.png)



<br />

## 🤔 기술적 이슈와 해결 과정
- Stream 써야할까?
    - [Stream API에 대하여](https://velog.io/@yewo2nn16/Java-Stream-API)
- Gmail STMP 이용하여 이메일 전송하기
    - [gmail 보내기](https://velog.io/@yewo2nn16/Email-이메일-전송하기with-첨부파일)
- AWS EC2에 배포하기
    - [서버 배포하기-1](https://velog.io/@yewo2nn16/SpringBoot-서버-배포)
    - [서버 배포하기-2](https://velog.io/@yewo2nn16/SpringBoot-서버-배포-인텔리제이에서-jar-파일-빌드해서-배포하기)


<br />

## 💁‍♂️ 프로젝트 팀원
|Backend|Frontend|
|:---:|:---:|
| ![](https://github.com/yewon-Noh.png?size=120) | ![](https://github.com/SeongHo-C.png?size=120) |
|[노예원](https://github.com/yewon-Noh)|[이성호](https://github.com/SeongHo-C)|






<p>'스프링' 으로 검색을 한 경우 아래와 같이 각각의 도서관들의 검색 결과가 나온다. </p> <br/>
<p>오른쪽에는 내가 관심도서로 등록한 도서들의 목록들이 나온다.</p>

![image](https://github.com/user-attachments/assets/286231c1-849e-473f-ba6d-61529fc5c648)
![image](https://github.com/user-attachments/assets/69268fad-a5cd-48f8-bee7-eff50aeed4e0)



<p>제가 사용 할 수 있는 전자도서관들을 각각의 웹사이트에서 검색하는 것이 불편해 하나의 웹사이트에서 
여러개의 도서관들을 검색 가능 하고, 각 도서관 마다 대출 가능한 도서들을 관심 도서로 등록을 할 수있게 만든 서비스입니다.
</p>


<p> 간단하게 흐름을 표시 한 aws 아키텍처 흐름입니다. </p>
<p> 비용 절감을 가장 우선시하게 만든 아키텍처입니다. 모든 백엔드는 Lambda를 기반으로 만들었습니다.</p>

![image](https://github.com/user-attachments/assets/cdc2aac3-540f-4dae-ae58-af76af5a8335)


