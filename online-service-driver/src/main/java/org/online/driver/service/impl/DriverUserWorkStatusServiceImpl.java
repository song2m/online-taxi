package org.online.driver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.online.common.configs.BusinessException;
import org.online.common.dto.ChangeDriverWorkStatusParam;
import org.online.common.model.DriverUserWorkStatusEntity;
import org.online.driver.mapper.DriverUserWorkStatusMapper;
import org.online.driver.service.IDriverUserWorkStatusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class DriverUserWorkStatusServiceImpl implements IDriverUserWorkStatusService {

    @Resource
    private DriverUserWorkStatusMapper driverUserWorkStatusMapper;

    /**
     * 查询司机工作状态
     */
    @Override
    public DriverUserWorkStatusEntity getDriverWorkStatus(Long driverId) {
        LambdaQueryWrapper<DriverUserWorkStatusEntity> wrapper = Wrappers.lambdaQuery(DriverUserWorkStatusEntity.class);
        wrapper.eq(DriverUserWorkStatusEntity::getDriverId, driverId);
        return driverUserWorkStatusMapper.selectOne(wrapper);

    }

    /**
     * 更改司机工作状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int changeDriverWorkStatus(ChangeDriverWorkStatusParam param) {
        String driverId = param.getDriverId();
        LambdaQueryWrapper<DriverUserWorkStatusEntity> wrapper = Wrappers.lambdaQuery(DriverUserWorkStatusEntity.class);
        wrapper.eq(DriverUserWorkStatusEntity::getDriverId, driverId);
        DriverUserWorkStatusEntity workStatus = driverUserWorkStatusMapper.selectOne(wrapper);

        if (ObjectUtils.isEmpty(workStatus)) {
            throw new BusinessException("司机不存在");
        }
        workStatus.setWorkStatus(param.getWorkStatus());
        LocalDateTime now = LocalDateTime.now();
        workStatus.setGmtModified(now);
        return driverUserWorkStatusMapper.updateById(workStatus);
    }
}
