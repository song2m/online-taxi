package org.online.order.service;

import org.online.common.dto.CreateOrderParam;
import org.online.common.dto.OrderDTO;
import org.online.common.utils.ResponseResult;

public interface IOrderService {


    /**
     * 创建订单
     */
    ResponseResult<OrderDTO> createOrder(CreateOrderParam param);

    /**
     * 查询是否有正在进行的订单
     * @param passengerPhone 乘客电话号码
     */
    Boolean isOrdering(String passengerPhone);

}
