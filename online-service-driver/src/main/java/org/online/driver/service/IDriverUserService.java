package org.online.driver.service;

import org.online.common.model.DriverUserEntity;

public interface IDriverUserService {

    /**
     * 新增司机用户
     */
    int newDriverUser(DriverUserEntity driverUser);

    /**
     * 修改司机信息
     */
    int updateDriverUser(DriverUserEntity driverUser);

    /**
     * 根据手机号码查询司机
     * @param phone 手机号
     * @return 司机信息
     */
    DriverUserEntity getDriverUserByPhone(String phone);
}
