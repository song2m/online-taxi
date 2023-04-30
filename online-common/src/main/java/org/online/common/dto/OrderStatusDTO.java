package org.online.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单状态
 *
 * @author songming
 */
@Data
public class OrderStatusDTO {

    private Integer statusValue;

    private String statusLabel;

    private LocalDateTime time;
}
