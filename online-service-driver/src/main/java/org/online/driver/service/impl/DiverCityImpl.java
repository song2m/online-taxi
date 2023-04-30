package org.online.driver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.online.common.model.ViewDriverCityWorkStateEntity;
import org.online.driver.mapper.ViewDriverCityWorkStateMapper;
import org.online.driver.service.IDiverCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DiverCityImpl implements IDiverCityService {

    @Resource
    private ViewDriverCityWorkStateMapper viewDriverCityWorkStateMapper;

    @Override
    public boolean isUsableDriver(String cityCode) {
        LambdaQueryWrapper<ViewDriverCityWorkStateEntity> wrapper = Wrappers.lambdaQuery(ViewDriverCityWorkStateEntity.class);
        wrapper.eq(ViewDriverCityWorkStateEntity::getCityCode, cityCode);
        Long count = viewDriverCityWorkStateMapper.selectCount(wrapper);
        return count > 0;
    }
}
