## RestTemplate 와 WebClient의 차이점

- 동기(RestTemplate) 와 비동기(WebClient)
  -  RestTemplate : 요청을 보낸 후 응답이 도착할 때 까지 기다린다.
  -  WebClient : 요청을 보낸 후 응답을 기다리지 않고 다음 작업 실시
- Blocking(RestTemplate) 와 NonBlocking(WebClinet)
  -  RestTemplate : 멀티스레드와 Blocking 방식으로 작업이 완료될 때까지 제어권을 가지고 있기 때문에 다른 처리를 못함
  -  WebClient : 싱글스레드와 NonBlocking 방식으로 바로 리턴해서 제어권을 넘겨줘서 동시에 여러 요청을 처리 가능

RestTemplate는 Spring 5.0 이후 deprecated 됨
WebClient는  Spring 5.0 이후에 나왔고 현재 Spring에서 권장되는 Http 클라이언트

WebClient는 함수형 프로그래밍 스타일 지원하기 때문에 로직을 더 읽기 쉽고 유연하게 작성 가능