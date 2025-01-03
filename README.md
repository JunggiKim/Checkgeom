

<div align
 
<br/>

## 프로젝트 소개 

<br/>
<p>서비스 URL : http://www.checkgeom.com </p>
<p> Checkgeom은 제가 사용할 수 있는 전자도서관들을 각각의 웹사이트에서 검색하는 것이 불편해 하나의 웹사이트에서 
여러개의 도서관들을 검색 가능하고, 각 도서관마다 대출 가능한 도서들을 관심 도서로 등록할 수 있게 만든 서비스입니다.
</p>

<br />

## 화면 구성 

<br/>

<p>검색과 로그인을 하기 전 첫 화면입니다. </p>

![image](https://github.com/user-attachments/assets/dbe08381-9441-4c9d-9266-a35147a955de)


<p>로그인 후 "스프링" 으로 검색을 하면 아래와 같이 각각의 도서관들의 검색 결과가 나오고.
오른쪽에서 관심도서로 등록 가능하고 내가 관심도서로 등록한 도서들의 목록들이 나옵니다.
 </p> 

![image](https://github.com/user-attachments/assets/286231c1-849e-473f-ba6d-61529fc5c648)
![image](https://github.com/user-attachments/assets/69268fad-a5cd-48f8-bee7-eff50aeed4e0)



## 아키텍쳐

<p> 간단하게 흐름을 표시 한 Infra AWS 아키텍처 흐름입니다.
비용 절감을 가장 우선시 한 아키텍처입니다. 모든 백 엔드는 서버리스로 만들었습니다. </p>

![image](https://github.com/user-attachments/assets/e96445fc-590d-45e1-bee1-18b4128e304e)

<br/>
<p> Checkgeom 의 백엔드 Applications architecture 입니다.
   기존 Layered Architecture 에서 Service 와 Infrastructure 사이에 Implementation 를 추가 했습니다.
  Implementation은 상세 비즈니스 로직 함수만을 가지고 있고 Service 가 퍼사드 가되어서 Implementation 의존해 사용하는 방식으로 설계했습니다. <br/>
 architecture 규칙은 코드의 재활용성을 위해 Implementation 만 같은 Layer의 의존을 허용 하고 다른 Layer는 하위의 Layer만 의존을 허용하는 것으로 정했습니다.  
 </p>

![image](https://github.com/user-attachments/assets/7b7b74ca-62be-4158-919a-33c613d53d70)


## ⚙ 기술 스택
### dev
<div>
Kotlin , JPA , Spring-Cloud-Function , JOOQ ,  Node , React 
</div>

### Infra
<div>
Lambda , EC2 , RDS , Docker , GitHub Actions , AWS-SAM 
</div>


<br />
 
## 🤔 기술적 이슈 및 레이어 규칙 
(https://kjg-steady.tistory.com/529)   <br/>
<a href= "https://github.com/spring-cloud/spring-cloud-function/pull/1199"> Spring-Cloud-Function 오픈소스 기여</a>
<!-- Lambda 콜드스타트시 동적 IP활당으로 인한 MySQL 복수의 커넥션 점유 -->























