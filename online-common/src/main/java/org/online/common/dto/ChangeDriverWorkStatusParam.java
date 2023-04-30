package org.online.common.dto;

import lombok.Data;

/**
 * 修改司机工作状态请求参数
 *
 * @author songming
 */
@Data
public class ChangeDriverWorkStatusParam {

    private String driverId;
    private Integer workStatus;
}
