package org.online.api.feign;

import org.online.common.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-driver")
public interface DriverFeign {

    @GetMapping("driver/is-exist")
    ResponseResult<String> isExistByPhone(@RequestParam("phone") String phone);


    @GetMapping("driver/is-usable")
    ResponseResult<Boolean> isUsableDriver(@RequestParam("cityCode") String cityCode);
}
