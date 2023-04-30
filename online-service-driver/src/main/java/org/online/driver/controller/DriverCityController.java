package org.online.driver.controller;

import org.online.common.utils.ResponseResult;
import org.online.driver.service.IDiverCityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.online.common.constants.CommonStatusEnum.CITY_DRIVER_EMPTY;

@RestController
public class DriverCityController {

    @Resource
    private IDiverCityService diverCityService;

    @GetMapping("driver/is-usable")
    public ResponseResult<Boolean> isUsableDriver(String cityCode) {
        boolean isUsable = diverCityService.isUsableDriver(cityCode);
        return isUsable ? ResponseResult.success(true) : ResponseResult.error(CITY_DRIVER_EMPTY);
    }
}
