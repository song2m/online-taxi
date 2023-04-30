package org.online.common.dto;

import lombok.Data;

@Data
public class LoginParam {

    private String phone;
    private String captcha;
}
