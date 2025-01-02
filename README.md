서비스 URL : http://www.checkgeom.com

<div align="center">


### 프로젝트 소개 

<p> 제가 사용 할 수 있는 전자도서관들을 각각의 웹사이트에서 검색하는 것이 불편해 하나의 웹사이트에서 
여러개의 도서관들을 검색 가능 하고, 각 도서관 마다 대출 가능한 도서들을 관심 도서로 등록을 할 수있게 만든 서비스입니다.
</p>
<br />

### 화면 구성

검색과 로그인을 하기 전 첫 화면입니다.
![image](https://github.com/user-attachments/assets/dbe08381-9441-4c9d-9266-a35147a955de)


<p>"스프링" 으로 검색을 한 경우 아래와 같이 각각의 도서관들의 검색 결과가 나온다. </p> <br/>
<p>오른쪽에는 내가 관심도서로 등록한 도서들의 목록들이 나온다.</p>

![image](https://github.com/user-attachments/assets/286231c1-849e-473f-ba6d-61529fc5c648)
![image](https://github.com/user-attachments/assets/69268fad-a5cd-48f8-bee7-eff50aeed4e0)



## ⚙ 기술 스택
### dev
<div>
Kotlin , JPA , Spring-Cloud-Function , Node , React 
</div>

### Infra
<div>
Lambda , EC2 , AWS-SAM 
</div>



<br />

## 🛠️ 프로젝트 아키텍쳐

<p> 간단하게 흐름을 표시 한 aws 아키텍처 흐름입니다. </p>
<p> 비용 절감을 가장 우선시 하게 만든 아키텍처입니다. 모든 백엔드는 Lambda를 기반으로 만들었습니다.</p>

![image](https://github.com/user-attachments/assets/cdc2aac3-540f-4dae-ae58-af76af5a8335)

<br />
 
<!-- ## 🤔 기술적 이슈와 해결 과정  -->
<!-- Lambda 콜드스타트시 동적 IP활당으로 인한 MySQL 복수의 커넥션 점유 -->
      
<!-- Web scraping 너무 늦은 응답시간  -->


<br />














