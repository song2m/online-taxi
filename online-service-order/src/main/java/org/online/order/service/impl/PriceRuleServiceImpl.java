package org.online.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.online.common.dto.CreatePriceRuleParam;
import org.online.common.model.PriceRuleEntity;
import org.online.order.mapper.PriceRuleMapper;
import org.online.order.service.IPriceRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;

@Service
public class PriceRuleServiceImpl implements IPriceRuleService {

    @Resource
    private PriceRuleMapper priceRuleMapper;

    @Override
    public PriceRuleEntity searchNewestPriceRule(String cityCode) {

        LambdaQueryWrapper<PriceRuleEntity> wrapper = Wrappers.lambdaQuery(PriceRuleEntity.class);
        wrapper.eq(PriceRuleEntity::getCityCode, cityCode)
                .orderByDesc(PriceRuleEntity::getFareVersion)
                .last("limit 1");

        return priceRuleMapper.selectOne(wrapper);
    }

    @Override
    public int createPriceRule(CreatePriceRuleParam param) {
        String cityCode = param.getCityCode();

        LambdaQueryWrapper<PriceRuleEntity> wrapper = Wrappers.lambdaQuery(PriceRuleEntity.class);
        wrapper.eq(PriceRuleEntity::getCityCode, cityCode);
        Long count = priceRuleMapper.selectCount(wrapper);

        if (count > 0)
            return 0;

        PriceRuleEntity rule = new PriceRuleEntity();
        rule.setCityCode(cityCode);
        rule.setStartFare(param.getStartFare());
        rule.setStartMile(param.getStartMile());
        rule.setUnitPricePerMile(param.getUnitPricePerMile());
        rule.setFareVersion(1);

        return priceRuleMapper.insert(rule);
    }

    @Override
    public Double countPrice(Double km, PriceRuleEntity priceRule) {

        Double startFare = priceRule.getStartFare();
        Integer startMile = priceRule.getStartMile();
        Double unitPricePerMile = priceRule.getUnitPricePerMile();

        if (km < startMile)
            return startFare;

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(km * unitPricePerMile));
    }
}
