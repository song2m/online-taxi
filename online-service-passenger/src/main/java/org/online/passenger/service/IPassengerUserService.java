package org.online.passenger.service;

import org.online.common.model.PassengerUserEntity;

public interface IPassengerUserService {

    /**
     * 根据手机号码查询乘客
     *
     * @param phone 手机号
     * @return 乘客信息
     */
    PassengerUserEntity getPassengerUserByPhone(String phone);
}
