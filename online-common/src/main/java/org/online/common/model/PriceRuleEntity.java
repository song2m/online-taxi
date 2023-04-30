package org.online.common.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("price_rule")
public class PriceRuleEntity implements Serializable {

    @TableId
    private Long id;

    /**
     * 城市代码
     */
    private String cityCode;

    /**
     * 起步价
     */
    private Double startFare;

    /**
     * 起步里程
     */
    private Integer startMile;

    /**
     * 单位距离价格（千米）
     */
    private Double unitPricePerMile;


    /**
     * 版本，默认1，修改往上增。
     */
    private Integer fareVersion;

}
