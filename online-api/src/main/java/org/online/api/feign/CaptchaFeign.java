package org.online.api.feign;

import org.online.common.dto.CaptchaParam;
import org.online.common.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-captcha")
public interface CaptchaFeign {

    @PostMapping("captcha/check")
    ResponseResult<String> checkCaptcha(@RequestBody CaptchaParam param);
}
