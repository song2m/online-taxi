package org.online.map.utils;

import lombok.Data;

/**
 * 高德地图api响应体
 *
 * @author songming
 */
@Data
public class AMapBaseResult {

    /**
     * 值为0或1，0表示失败；1表示成功
     */
    private Integer status;

    /**
     * 返回状态说明，status为0时，info返回错误原因，否则返回“OK”。
     */
    private String info;
}
