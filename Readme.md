## 1.	Java + Spring Boot 구조로, RestFul API 형태로, POST Multipart 로 파일을 업로드하는 API, 파일명으로 파일을 조회하는 API 코드를 작성하시오. 
a.	파일은 서버의 로컬 파일 스토리지에 저장합니다. 
b.	Controller, Service, Dto, VO 체계로 작성해보세요. 
c.	SpringBoot 를 사용합니다.
d.	파일 포맷은 이미지 파일(jpg, png 등)을 대상으로 하고, 조회시 <img src=”....”> tag 로 실제 이미지를 브라우저에 보여줄 수 있는 API를 작성하세요.  

## 2. HashMap을 이용해서, String의 글자수를 카운트하는 Method를 Java로 작성해 보세요.

## 3.	Json 으로 전달받은, 입력값을, 500건마다, bulk 로 Insert하는 Java 프로그램을 작성해 보세요. MySQL를 사용하고, MyBatis 또는 JPA중 편한 구성을 사용해 주세요.   

## 4. 동시접속하여 그룹수업에 예약을 처리하는 API를 설계하려고 한다. 아래는 Data Model 이다. 이를 클래스 다이어그램으로 작성해서 제출하세요. 
a.	예약 프로세스는 아래이다.
i.	이미 사용가능한 티켓을 구매한 상태에 한함. 티켓구매내역이 없다면, 에러 (reservation_unit - used_number = 예약에 사용할 수 있는 티켓좌석수) 
ii.	티켓이 있다면, Queue 에 적재하는 클래스 다이어그램 작성
iii.	Queue 에서 읽어서, 예약처리 (트랜잭션 보장되어야 함)하는 클래스 다이어그램 작성
1.	티켓 차감
2.	그룹수업 가능 예약좌석수 차감
3.	예약 내역 기록 
b.	Queue 를 사용합니다. AWS SQS나 RabbitMQ등 메시지 Queue를 사용합니다.  Quque에 요청을 보내고, 이를 처리하는 클래스를 설계하세요. 
c.	예약 티켓 테이블 구성(ticket)
![image](https://github.com/jihoonLeee/redblue_test/assets/59809529/8351d342-57a5-4a3e-8886-9a724eae44d2)

## 5.	RestTemplate 과 WebClient로 다음 외부 Rest API를 호출해서 SMS를 전송하는 Method를 작성하고 차이점에 대해서, 두 방식의 차이점을 설명하시오.
a.	외부 Rest API end point
i.	https://{hostname}/api/sendSMS 
b.	지원 Method, Content Type
i.	POST  
ii.	JSON
c.	Http Header
i.	Bearer Token 으로 Authorization Header 추가 
d.	Request JSON Sample 
		{
 “title” : “SMS Title 샘플",
		“content”  : “안녕하세요! SMS 샘플 테스트입니다.”,
“targetPhoneNumber” : “+82-10-1234-1234”
} 

e.	Response 
i.	HttpStatus : 200 
ii.	{ “message” : “Successfully sent” } 
f.	Error Exceptions 
i.	403, 404, 500 Http Status Errors 
