package org.online.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-map")
public interface MapFeign {

    @GetMapping("map/driving")
    String countDistance(@RequestParam("start") String start,
                         @RequestParam("end") String end,
                         @RequestParam("strategy")String strategy);
}
