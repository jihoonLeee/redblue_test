package redblue.sms.test.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsRequestVo {

    private String title;
    private String content;
    private String targetPhoneNumber;
}
