package org.online.common.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("driver_car_binding_relationship")
public class DriverCarBindingRelationshipEntity implements Serializable {

    private Long id;

    /**
     * 司机ID
     */
    private Long driverId;

    /**
     * 车辆Id
     */
    private Long carId;

    /**
     * 绑定状态：1：绑定，2：解绑
     */
    private Integer bindState;

    /**
     * 绑定时间
     */
    private LocalDateTime bindingTime;

    /**
     * 解绑时间
     */
    private LocalDateTime unBindingTime;

}
