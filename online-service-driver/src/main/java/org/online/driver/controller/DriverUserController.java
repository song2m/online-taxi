package org.online.driver.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.online.common.constants.CommonStatusEnum;
import org.online.common.model.DriverUserEntity;
import org.online.common.utils.ResponseResult;
import org.online.driver.service.IDriverUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class DriverUserController {

    @Resource
    private IDriverUserService driverUserService;

    /**
     * 新司机注册
     *
     * @param driverUser 注册参数
     */
    @PostMapping("driver")
    public ResponseResult<String> newDriverUser(@RequestBody DriverUserEntity driverUser) {
        int flag = driverUserService.newDriverUser(driverUser);
        return flag > 0 ? ResponseResult.success("司机注册成功") : ResponseResult.error("司机注册失败");
    }

    /**
     * 修改司机信息
     *
     * @param driverUser 修改信息，必须包含司机id
     */
    @PutMapping("driver")
    public ResponseResult<String> updateDriverUser(@RequestBody DriverUserEntity driverUser) {
        int flag = driverUserService.updateDriverUser(driverUser);
        return flag > 0 ? ResponseResult.success("信息更新成功") : ResponseResult.error("信息更新失败");
    }

    /**
     * 判断手机号司机是否存在
     */
    @GetMapping("driver/is-exist")
    public ResponseResult<String> isExistByPhone(String phone) {
        DriverUserEntity driver = driverUserService.getDriverUserByPhone(phone);
        if (ObjectUtils.isEmpty(driver))
            return ResponseResult.error(CommonStatusEnum.DRIVER_NOT_EXITST);
        return ResponseResult.success();
    }
}
