package org.online.order.service;

import org.online.common.dto.CreatePriceRuleParam;
import org.online.common.model.PriceRuleEntity;

public interface IPriceRuleService {

   /**
    * 查询城市最新计价规则
    * @param cityCode 城市编码
    * @return 计价详情
    */
   PriceRuleEntity searchNewestPriceRule(String cityCode);


   /**
    * 新建计价规则
    */
   int createPriceRule(CreatePriceRuleParam param);


   /**
    * 计算费用逻辑
    * @param km 公里数
    * @param priceRule 计价标准
    */
   Double countPrice(Double km,PriceRuleEntity priceRule);
}
