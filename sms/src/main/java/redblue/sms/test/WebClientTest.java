package redblue.sms.test;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import redblue.sms.test.dto.SmsResponseDto;
import redblue.sms.test.vo.SmsRequestVo;


@RequiredArgsConstructor
public class WebClientTest {

    private final WebClient webClient;
    private final String  API_URL  = "https://{hostname}/api/sendSMS";
    public Mono<ResponseEntity<SmsResponseDto>> requestWebClientForSms(String token, SmsRequestVo vo){

        Mono<ResponseEntity<SmsResponseDto>> mono =  webClient.post()
                .uri(API_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(token))
                .bodyValue(vo)
                .retrieve()
                .onStatus(status -> !status.is2xxSuccessful(), response ->
                        response.bodyToMono(String.class).map(RuntimeException::new))
               .toEntity(SmsResponseDto.class);

        return mono;
    }
}
// api end point - https://{hostname}/api/sendSMS
// method - POST

// content Type - JSON
// HTTP Header - Bearer Token 으로 Auth Header

// Request JSON SAMPLE
// {"title" :"SMS titme 샘플" , "content" : "콘텐츠" ,"targetPhoneNumber" : "+82-10-1234-1234"}

// Response
// HTTP Status - 200
// {"message" : "Successfully sent"}
// Error
// 403,404,500 Http Status Error