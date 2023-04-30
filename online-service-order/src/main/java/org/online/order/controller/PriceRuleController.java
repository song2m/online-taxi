package org.online.order.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.online.common.dto.CreatePriceRuleParam;
import org.online.common.model.PriceRuleEntity;
import org.online.common.utils.ResponseResult;
import org.online.order.service.IPriceRuleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.online.common.constants.CommonStatusEnum.PRICE_RULE_EMPTY;
import static org.online.common.constants.CommonStatusEnum.PRICE_RULE_EXISTS;

@RestController
public class PriceRuleController {

    @Resource
    private IPriceRuleService ruleService;

    @PostMapping("price-rule/new")
    public ResponseResult<String> newPriceRule(@RequestBody CreatePriceRuleParam param) {
        int flag = ruleService.createPriceRule(param);
        return flag > 0 ? ResponseResult.success() : ResponseResult.error(PRICE_RULE_EXISTS);
    }

    @GetMapping("price-rule/search-new")
    public ResponseResult<PriceRuleEntity> searchNewestPriceRule(@RequestParam String cityCode) {
        PriceRuleEntity rule = ruleService.searchNewestPriceRule(cityCode);
        if (ObjectUtils.isEmpty(rule))
            return ResponseResult.error(PRICE_RULE_EMPTY);
        return ResponseResult.success(rule);
    }
}
