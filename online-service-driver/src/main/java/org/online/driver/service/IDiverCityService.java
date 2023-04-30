package org.online.driver.service;

public interface IDiverCityService {

    /**
     * 判断城市是否有可用司机
     *
     * @param cityCode 城市编码
     */
    boolean isUsableDriver(String cityCode);
}
