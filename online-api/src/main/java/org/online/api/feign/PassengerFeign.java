package org.online.api.feign;

import org.online.common.model.PassengerUserEntity;
import org.online.common.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-passenger")
public interface PassengerFeign {

    @GetMapping("passenger/is-exist")
    ResponseResult<String> isExistByPhone(@RequestParam("phone") String phone);

    @GetMapping("passenger/search")
    ResponseResult<PassengerUserEntity> searchPassengerByPhone(@RequestParam("phone") String phone);
}
