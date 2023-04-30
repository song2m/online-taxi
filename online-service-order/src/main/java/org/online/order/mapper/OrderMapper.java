package org.online.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.online.common.model.OrderInfoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<OrderInfoEntity> {

}
