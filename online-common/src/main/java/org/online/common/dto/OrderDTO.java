package org.online.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 创建订单后返回的数据
 *
 * @author songming
 */
@Data
@Accessors(chain = true)
public class OrderDTO {

    private String passengerPhone;

    private String startAddress;

    private String endAddress;

    private Double kilometre;

    private Double planMoney;

    private LocalDateTime orderTime;

}
