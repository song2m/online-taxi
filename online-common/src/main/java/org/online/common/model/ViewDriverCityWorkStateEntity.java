package org.online.common.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 司机城市工作状态视图
 *
 * @author songming
 */
@Data
@TableName("v_driver_city_work_status")
public class ViewDriverCityWorkStateEntity {

    @TableId
    private Long driverId;
    private Long cityCode;
    private Integer workStatus;
}
