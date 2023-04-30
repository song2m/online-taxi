package org.online.driver.service;

import org.online.common.dto.ChangeDriverWorkStatusParam;
import org.online.common.model.DriverUserWorkStatusEntity;

public interface IDriverUserWorkStatusService {

    /**
     * 查询司机工作状态
     *
     * @param driverId 司机id
     * @return 工作状态
     */
    DriverUserWorkStatusEntity getDriverWorkStatus(Long driverId);

    /**
     * 更改司机工作状态
     *
     * @param param 司机id和工作状态
     */
    int changeDriverWorkStatus(ChangeDriverWorkStatusParam param);
}
