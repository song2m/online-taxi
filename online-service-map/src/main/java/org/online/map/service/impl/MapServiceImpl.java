package org.online.map.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.online.common.model.DistrictEntity;
import org.online.map.mapper.DicDistrictMapper;
import org.online.map.service.IMapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MapServiceImpl implements IMapService {

    @Resource
    private DicDistrictMapper dicDistrictMapper;

    @Override
    public DistrictEntity searchDistrict(String keywords,int level) {

        LambdaQueryWrapper<DistrictEntity> wrapper = Wrappers.lambdaQuery(DistrictEntity.class);
        wrapper.like(DistrictEntity::getAddressName,keywords)
                .eq(DistrictEntity::getLevel,level);
        return dicDistrictMapper.selectOne(wrapper);
    }
}
