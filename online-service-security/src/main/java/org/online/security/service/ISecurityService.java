package org.online.security.service;

import org.online.common.dto.CaptchaParam;
import org.online.common.utils.ResponseResult;

public interface ISecurityService {

    /**
     * 登录
     *
     * @param param 手机号码+验证码
     */
    ResponseResult<?> login(CaptchaParam param);
}
