package org.online.driver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.online.common.constants.DriverCarConstants;
import org.online.common.model.DriverUserEntity;
import org.online.common.model.DriverUserWorkStatusEntity;
import org.online.driver.mapper.CarMapper;
import org.online.driver.mapper.DriverUserMapper;
import org.online.driver.mapper.DriverUserWorkStatusMapper;
import org.online.driver.service.IDriverUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
@Slf4j
public class DriverUserServiceImpl implements IDriverUserService {

    @Resource
    private DriverUserMapper driverUserMapper;

    @Resource
    private DriverUserWorkStatusMapper driverUserWorkStatusMapper;

    @Resource
    private CarMapper carMapper;

    /**
     * 注册新司机
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int newDriverUser(DriverUserEntity driverUser) {
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtCreate(now);
        driverUser.setGmtModified(now);
        driverUser.setState(DriverCarConstants.DRIVER_STATE_VALID);
        int insert = driverUserMapper.insert(driverUser);

        // 初始化司机工作状态表
        if (insert > 0) {
            DriverUserWorkStatusEntity workStatus = new DriverUserWorkStatusEntity();
            workStatus.setDriverId(driverUser.getId());
            workStatus.setWorkStatus(DriverCarConstants.DRIVER_WORK_STATUS_STOP);
            workStatus.setGmtCreate(now);
            workStatus.setGmtModified(now);
            driverUserWorkStatusMapper.insert(workStatus);
        }
        return insert;
    }

    /**
     * 修改司机信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateDriverUser(DriverUserEntity driverUser) {
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtModified(now);
        return driverUserMapper.updateById(driverUser);
    }

    /**
     * 根据手机号查询司机信息
     */
    @Override
    public DriverUserEntity getDriverUserByPhone(String phone) {
        LambdaQueryWrapper<DriverUserEntity> wrapper = Wrappers.lambdaQuery(DriverUserEntity.class);
        wrapper.eq(DriverUserEntity::getDriverPhone, phone)
                .eq(DriverUserEntity::getState, DriverCarConstants.DRIVER_STATE_VALID);
       return driverUserMapper.selectOne(wrapper);
    }

}