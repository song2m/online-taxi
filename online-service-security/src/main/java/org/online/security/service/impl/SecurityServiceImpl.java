package org.online.security.service.impl;

import org.online.common.constants.CommonStatusEnum;
import org.online.common.constants.TokenConstants;
import org.online.common.dto.CaptchaParam;
import org.online.common.dto.TokenDTO;
import org.online.common.utils.JwtUtil;
import org.online.common.utils.RedisPrefixUtils;
import org.online.common.utils.ResponseResult;
import org.online.api.feign.CaptchaFeign;
import org.online.security.service.ISecurityService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class SecurityServiceImpl implements ISecurityService {

    @Resource
    private CaptchaFeign captchaFeign;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ResponseResult<?> login(CaptchaParam param) {

        Integer identity = param.getIdentity();
        String phone = param.getPhone();

        ResponseResult<String> result = captchaFeign.checkCaptcha(param);

        int status = result.getStatus();
        if (status != CommonStatusEnum.SUCCESS.getCode()) {
            return result;
        }

        String accessToken = JwtUtil.generatorToken(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtil.generatorToken(phone, identity, TokenConstants.REFRESH_TOKEN_TYPE);

        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey, accessToken, 30, TimeUnit.MINUTES);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(phone, identity, TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey, refreshToken, 31, TimeUnit.MINUTES);

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setAccessToken(accessToken);
        tokenDTO.setRefreshToken(refreshToken);
        LocalDateTime expireTime = LocalDateTime.now().plusMinutes(30);
        tokenDTO.setExpiryDate(expireTime);

        return ResponseResult.success(tokenDTO);
    }
}
