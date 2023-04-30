package org.online.map.controller;

import org.online.common.model.DistrictEntity;
import org.online.common.utils.ResponseResult;
import org.online.map.remote.DrivingClient;
import org.online.map.service.IMapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MapController {

    @Resource
    private DrivingClient drivingClient;

    @Resource
    private IMapService mapService;


    @GetMapping("map/district/search")
    public ResponseResult<DistrictEntity> searchDistrict(String keywords, int level) {

        DistrictEntity district = mapService.searchDistrict(keywords, level);
        return ResponseResult.success(district);

    }

    @GetMapping("map/driving")
    public String countDistance(String start, String end, String strategy) {
        return drivingClient.countDistance(start, end, strategy);
    }
}
