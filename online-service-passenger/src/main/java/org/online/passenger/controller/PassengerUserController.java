package org.online.passenger.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.online.common.constants.CommonStatusEnum;
import org.online.common.model.PassengerUserEntity;
import org.online.common.utils.ResponseResult;
import org.online.passenger.service.IPassengerUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PassengerUserController {

    @Resource
    private IPassengerUserService passengerUserService;

    /**
     * 判断手机号乘客是否存在
     */
    @GetMapping("passenger/is-exist")
    public ResponseResult<String> isExistByPhone(String phone) {
        PassengerUserEntity passenger = passengerUserService.getPassengerUserByPhone(phone);
        if (ObjectUtils.isEmpty(passenger))
            return ResponseResult.error(CommonStatusEnum.USER_NOT_EXISTS);
        return ResponseResult.success();
    }

    @GetMapping("passenger/search")
    public ResponseResult<PassengerUserEntity> searchPassengerByPhone(String phone){
        PassengerUserEntity passenger = passengerUserService.getPassengerUserByPhone(phone);
        if (ObjectUtils.isEmpty(passenger))
            return ResponseResult.error(CommonStatusEnum.USER_NOT_EXISTS);
        return ResponseResult.success(passenger);
    }
}
