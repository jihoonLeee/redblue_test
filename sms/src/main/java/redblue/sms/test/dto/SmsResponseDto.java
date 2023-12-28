package redblue.sms.test.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
public class SmsResponseDto {
    private String message;
    private HttpStatusCode code;
    public SmsResponseDto (HttpStatusCode code, String message){
        this.message=message;
        this.code = code;
    }
}
