package org.online.common.dto;

import lombok.Data;

/**
 * 新建订单参数
 */
@Data
public class CreateOrderParam {

    /**
     * 乘客电话号码
     */
    private String passengerPhone;

    /**
     * 当前地区，市级城市
     */
    private String address;

    /**
     * 出发时间
     */
    private String departTime;

    /**
     * 出发信息（地址，经纬度）
     */
    private String departure;
    private String depLongitude;
    private String depLatitude;

    /**
     * 目的地信息
     */
    private String destination;
    private String destLongitude;
    private String destLatitude;

    /**
     * 路线规划策略
     */
    private String strategy;
}
