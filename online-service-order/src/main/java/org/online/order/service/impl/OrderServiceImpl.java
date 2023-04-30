package org.online.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.online.api.feign.DriverFeign;
import org.online.api.feign.MapFeign;
import org.online.api.feign.PassengerFeign;
import org.online.common.constants.AmapConfigConstants;
import org.online.common.constants.CommonStatusEnum;
import org.online.common.constants.OrderConstants;
import org.online.common.dto.CreateOrderParam;
import org.online.common.dto.OrderDTO;
import org.online.common.model.OrderInfoEntity;
import org.online.common.model.PassengerUserEntity;
import org.online.common.model.PriceRuleEntity;
import org.online.common.utils.ResponseResult;
import org.online.order.mapper.OrderMapper;
import org.online.order.service.IOrderService;
import org.online.order.service.IPriceRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.online.common.constants.CommonStatusEnum.*;

@Service
public class OrderServiceImpl implements IOrderService {

    private final Gson gson = new Gson();

    @Resource
    private DriverFeign driverFeign;

    @Resource
    private PassengerFeign passengerFeign;

    @Resource
    private MapFeign mapFeign;

    @Resource
    private OrderMapper orderMapper;


    @Resource
    private IPriceRuleService priceRuleService;


    @Override
    @Transactional
    public ResponseResult<OrderDTO> createOrder(CreateOrderParam param) {

        String passengerPhone = param.getPassengerPhone();
        ResponseResult<PassengerUserEntity> r1 = passengerFeign.searchPassengerByPhone(passengerPhone);
        PassengerUserEntity passenger = r1.getData();

        // 0.判断乘客是否有正在进行的订单 防止重复下单

        Boolean ing = this.isOrdering(passengerPhone);
        if (ing)
            return ResponseResult.error(CommonStatusEnum.ORDER_GOING_ON);

        // 1.判断当前城市是否有可用司机
        String address = param.getAddress();
        ResponseResult<Boolean> r2 = driverFeign.isUsableDriver(address);
        if (r2.getStatus() != CommonStatusEnum.SUCCESS.getCode())
            return ResponseResult.error(CITY_DRIVER_EMPTY);

        // 2.根据起始点和目的地获取两地距离 起：114.04085,22.617545 终：114.084177,22.54764
        String strategy = param.getStrategy();

        String depLongitude = param.getDepLongitude();
        String depLatitude = param.getDepLatitude();
        String start = depLongitude + "," + depLatitude;

        String destLongitude = param.getDestLongitude();
        String destLatitude = param.getDestLatitude();
        String end = destLongitude + "," + destLatitude;

        String amapResult = mapFeign.countDistance(start, end, strategy);
        JsonObject jsonObject = gson.fromJson(amapResult, JsonObject.class);

        int status = jsonObject.get(AmapConfigConstants.STATUS).getAsInt();
        if (status != AmapConfigConstants.SUCCESS) {
            return ResponseResult.error("路线规划失败");
        }

        double distance = jsonObject.get(AmapConfigConstants.ROUTE).getAsJsonObject()
                .get(AmapConfigConstants.PATHS).getAsJsonArray()
                .get(0).getAsJsonObject()
                .get(AmapConfigConstants.DISTANCE).getAsDouble();

        // 3.创建订单
        OrderInfoEntity order = new OrderInfoEntity();

        String departTime = param.getDepartTime();
        LocalDateTime time = LocalDateTime.parse(departTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        order.setPassengerId(passenger.getId())
                .setPassengerPhone(passengerPhone)
                .setAddress(address)
                .setOrderTime(LocalDateTime.now())
                .setDepartTime(time)
                .setDeparture(param.getDeparture())
                .setDepLongitude(depLongitude)
                .setDepLatitude(depLatitude)
                .setDestination(param.getDestination())
                .setDestLongitude(destLongitude)
                .setDestLatitude(destLatitude)
                .setOrderStatus(OrderConstants.ORDER_CREATE)
                .setGmtCreate(LocalDateTime.now())
                .setGmtModified(LocalDateTime.now());
        int insert = orderMapper.insert(order);

        if (insert < 0)
            return ResponseResult.error(CommonStatusEnum.ORDER_ING_ERROR);

        // 4.开始计算费用
        PriceRuleEntity rule = priceRuleService.searchNewestPriceRule(param.getAddress());
        if (ObjectUtils.isEmpty(rule))
            return ResponseResult.error(PRICE_RULE_EMPTY);

        // 5.返回订单信息
        OrderDTO orderDTO = new OrderDTO();
        Double price = priceRuleService.countPrice(distance / 1000, rule);
        orderDTO.setPassengerPhone(passengerPhone)
                .setStartAddress(param.getDeparture())
                .setEndAddress(param.getDestination())
                .setKilometre(distance / 1000)
                .setPlanMoney(price)
                .setOrderTime(LocalDateTime.now());

        return ResponseResult.success(orderDTO);
    }

    @Override
    public Boolean isOrdering(String passengerPhone) {

        LambdaQueryWrapper<OrderInfoEntity> wrapper = Wrappers.lambdaQuery(OrderInfoEntity.class);
        wrapper.eq(OrderInfoEntity::getPassengerPhone, passengerPhone)
                .gt(OrderInfoEntity::getOrderStatus, OrderConstants.ORDER_CREATE);
        List<OrderInfoEntity> orders = orderMapper.selectList(wrapper);

        return orders.size() > 0;
    }
}
