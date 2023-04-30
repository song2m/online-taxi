package org.online.common.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("passenger_user")
public class PassengerUserEntity implements Serializable {

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String passengerPhone;

    private String passengerName;

    /**
     * 0：未知，1：男，2：女
     */
    private Integer passengerGender;

    /**
     * 0：有效，1：失效
     */
    private Integer state;

    /**
     * 头像图片地址的url
     */
    private String profilePhoto;
}