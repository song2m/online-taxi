package org.online.passenger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.online.common.constants.PassengerConstants;
import org.online.common.model.PassengerUserEntity;
import org.online.passenger.mapper.PassengerUserMapper;
import org.online.passenger.service.IPassengerUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PassengerServiceImpl implements IPassengerUserService {

    @Resource
    private PassengerUserMapper passengerUserMapper;

    @Override
    public PassengerUserEntity getPassengerUserByPhone(String phone) {
        LambdaQueryWrapper<PassengerUserEntity> wrapper = Wrappers.lambdaQuery(PassengerUserEntity.class);
        wrapper.eq(PassengerUserEntity::getPassengerPhone, phone)
                .eq(PassengerUserEntity::getState, PassengerConstants.PASSENGER_STATE_VALID);
        return passengerUserMapper.selectOne(wrapper);
    }
}
