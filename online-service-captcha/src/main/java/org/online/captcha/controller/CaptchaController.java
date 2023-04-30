package org.online.captcha.controller;

import com.wf.captcha.SpecCaptcha;
import org.online.api.feign.DriverFeign;
import org.online.api.feign.PassengerFeign;
import org.online.captcha.utils.CaptchaUtil;
import org.online.captcha.utils.ImageCaptchaUtil;
import org.online.common.configs.BusinessException;
import org.online.common.constants.CommonStatusEnum;
import org.online.common.constants.IdentityConstants;
import org.online.common.dto.CaptchaParam;
import org.online.common.utils.RedisPrefixUtils;
import org.online.common.utils.ResponseResult;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
public class CaptchaController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private DriverFeign driverFeign;

    @Resource
    private PassengerFeign passengerFeign;

    @GetMapping("captcha/num")
    public ResponseResult<String> numberCaptcha(String phone, Integer identity) {

        if (IdentityConstants.DRIVER_IDENTITY !=identity && IdentityConstants.PASSENGER_IDENTITY!=identity){
            return ResponseResult.error("用户类型错误");
        }

        // 司机获取验证码，判断司机是否存在，不存在直接返回错误信息
        if (identity.equals(IdentityConstants.DRIVER_IDENTITY)) {
            ResponseResult<String> result = driverFeign.isExistByPhone(phone);
            if (CommonStatusEnum.SUCCESS.getCode() != result.getStatus()) {
                return result;
            }
        }

        // 乘客获取验证码，判断乘客是否存在，不存在直接返回错误信息
        if (identity.equals(IdentityConstants.PASSENGER_IDENTITY)) {
            ResponseResult<String> result = passengerFeign.isExistByPhone(phone);
            if (CommonStatusEnum.SUCCESS.getCode() != result.getStatus()) {
                return result;
            }
        }

        String captchaKey = RedisPrefixUtils.generatorKeyByPhone(phone, identity);
        String value = stringRedisTemplate.opsForValue().get(captchaKey);
        if (!ObjectUtils.isEmpty(value))
            return ResponseResult.error("请勿重复获取验证码");
        String captcha = CaptchaUtil.builderCaptchaOnlyNumber(6);

        stringRedisTemplate.opsForValue().set(captchaKey, captcha, 1, TimeUnit.MINUTES);

        return ResponseResult.success(captcha);
    }

    @GetMapping("captcha/img")
    @CrossOrigin
    public void imgCaptcha(HttpServletResponse response) {
        SpecCaptcha specCaptcha = ImageCaptchaUtil.buildImageCaptcha();
        try {
            specCaptcha.out(response.getOutputStream());
        } catch (IOException e) {
            throw new BusinessException("验证码获取失败，请重试。");
        }
    }


    @PostMapping("captcha/check")
    public ResponseResult<String> checkCaptcha(@RequestBody CaptchaParam param) {
        String phone = param.getPhone();
        Integer identity = param.getIdentity();
        String key = RedisPrefixUtils.generatorKeyByPhone(phone, identity);
        String value = stringRedisTemplate.opsForValue().get(key);

        if (ObjectUtils.isEmpty(value)) {
            return ResponseResult.error("验证码已过期");
        }
        boolean flag = CaptchaUtil.matchingCaptcha(param.getCaptcha(), value);

        if (!flag)
            return ResponseResult.error("验证码错误");
        stringRedisTemplate.delete(key);

        return ResponseResult.success("验证成功");
    }
}
