package org.online.map.service;

import org.online.common.model.DistrictEntity;

public interface IMapService {

    /**
     * 查询行政区域
     */
    DistrictEntity searchDistrict(String keywords,int level);
}
