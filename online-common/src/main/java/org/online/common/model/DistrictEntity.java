package org.online.common.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("dic_district")
public class DistrictEntity implements Serializable {

    /**
     * 地区编码
     */
    @TableId
    private String addressCode;

    /**
     * 地区名称
     */
    private String addressName;

    /**
     * 父级地区编码
     */
    private String parentAddressCode;

    /**
     * 级别
     */
    private Integer level;
}
