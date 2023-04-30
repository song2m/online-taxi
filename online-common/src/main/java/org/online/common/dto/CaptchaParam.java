package org.online.common.dto;

import lombok.Data;

/**
 * 手机+验证码参数
 *
 * @author songming
 */
@Data
public class CaptchaParam {

    String phone;
    String captcha;
    Integer identity;
}
