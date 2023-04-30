package org.online.common.dto;

import lombok.Data;

/**
 * 新建计价规则
 *
 * @author songming
 */
@Data
public class CreatePriceRuleParam {

    private String cityCode;

    private Double startFare;

    private Integer startMile;

    private Double unitPricePerMile;
}
