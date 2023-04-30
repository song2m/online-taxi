package org.online.driver.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.online.common.constants.CommonStatusEnum;
import org.online.common.dto.ChangeDriverWorkStatusParam;
import org.online.common.model.DriverUserWorkStatusEntity;
import org.online.common.utils.ResponseResult;
import org.online.driver.service.IDriverUserWorkStatusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class DriverUserWorkStatusController {

    @Resource
    private IDriverUserWorkStatusService driverUserWorkStatusService;

    /**
     * 查询司机工作状态
     */
    @GetMapping("driver/work-status/{driverId}")
    public ResponseResult<?> getDriverWorkStatus(@PathVariable Long driverId) {
        DriverUserWorkStatusEntity status = driverUserWorkStatusService.getDriverWorkStatus(driverId);
        if (ObjectUtils.isEmpty(status))
            return ResponseResult.error(CommonStatusEnum.DRIVER_NOT_EXITST);
        return ResponseResult.success(status);
    }

    /**
     * 更改司机工作状态
     */
    @PutMapping("driver/work-status")
    public ResponseResult<String> changeDriverWorkStatus(@RequestBody ChangeDriverWorkStatusParam param) {
        int flag = driverUserWorkStatusService.changeDriverWorkStatus(param);
        return flag > 0 ? ResponseResult.success("工作状态已更改") : ResponseResult.error("工作状态更改失败");
    }

}
