package redblue.sms.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import redblue.sms.test.dto.SmsResponseDto;
import redblue.sms.test.vo.SmsRequestVo;

@RequiredArgsConstructor
public class RestTemplateTest {

    private final RestTemplate restTemplate;

    private final String  API_URL  = "https://{hostname}/api/sendSMS";
    public SmsResponseDto requestRestTemplateForSms(String token, SmsRequestVo vo){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<SmsRequestVo> httpEntity = new HttpEntity<>(vo,headers);

        // exchange params [String url, HttpMethod method,@Nullable HttpEntity<?> requestEntity, Class<T> responseType]
        ResponseEntity<SmsResponseDto> response= restTemplate.exchange(
                API_URL,
                HttpMethod.POST,
                httpEntity,
                SmsResponseDto.class
        );
        return new SmsResponseDto(response.getStatusCode(),response.getBody().toString());

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
