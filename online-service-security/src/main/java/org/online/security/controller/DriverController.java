package org.online.security.controller;

import org.online.common.constants.IdentityConstants;
import org.online.common.dto.CaptchaParam;
import org.online.common.dto.LoginParam;
import org.online.common.utils.ResponseResult;
import org.online.security.service.ISecurityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DriverController {


    @Resource
    private ISecurityService securityService;

    @PostMapping("security/driver-login")
    public ResponseResult<?> driverLogin(@RequestBody LoginParam loginParam) {

        CaptchaParam param = new CaptchaParam();
        param.setPhone(loginParam.getPhone());
        param.setIdentity(IdentityConstants.DRIVER_IDENTITY);
        param.setCaptcha(loginParam.getCaptcha());
        return securityService.login(param);
    }

    @PostMapping("security/passenger-login")
    public ResponseResult<?> passengerLogin(@RequestBody LoginParam loginParam) {

        CaptchaParam param = new CaptchaParam();
        param.setPhone(loginParam.getPhone());
        param.setIdentity(IdentityConstants.PASSENGER_IDENTITY);
        param.setCaptcha(loginParam.getCaptcha());

        return securityService.login(param);
    }

}
