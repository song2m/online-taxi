package org.online.order.controller;

import org.online.common.dto.CreateOrderParam;
import org.online.common.dto.OrderDTO;
import org.online.common.utils.ResponseResult;
import org.online.order.service.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private IOrderService orderService;


    @PostMapping("order/create")
    public ResponseResult<OrderDTO> createOrder(@RequestBody CreateOrderParam param) {
        return orderService.createOrder(param);
    }

    /**
     * 查询乘客是否有正在进行的订单
     */
    @GetMapping("order/passenger-ing")
    public ResponseResult<Boolean> passengerOrderIng(String passengerPhone) {
        Boolean ing = orderService.isOrdering(passengerPhone);
        return ResponseResult.success(ing);
    }

}
