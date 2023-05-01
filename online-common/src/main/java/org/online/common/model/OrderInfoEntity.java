package org.online.common.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@TableName("order_info")
@Accessors(chain = true)
public class OrderInfoEntity extends BaseEntity{

    /**
     * 乘客ID
     */
    private Long passengerId;

    /**
     * 乘客手机号
     */
    private String passengerPhone;

    /**
     * 司机ID
     */
    private Long driverId;

    /**
     * 司机手机号
     */
    private String driverPhone;

    /**
     * 车辆Id
     */
    private Long carId;

    /**
     * 发起地行政区划代码
     */
    private String address;
    /**
     * 订单发起时间
     */
    private LocalDateTime orderTime;

    /**
     * 预计用车时间
     */
    private LocalDateTime departTime;

    /**
     * 预计出发地点详细地址
     */
    private String departure;

    /**
     * 预计出发地点经度
     */
    private String depLongitude;

    /**
     * 预计出发地点纬度
     */
    private String depLatitude;

    /**
     * 预计目的地
     */
    private String destination;

    /**
     * 预计目的地经度
     */
    private String destLongitude;

    /**
     * 预计目的地纬度
     */
    private String destLatitude;

    private Integer encrypt;
    /**
     * 运价版本
     */
    private Integer fareVersion;

    /**
     * 接单时车辆经度
     */
    private String receiveOrderCarLongitude;

    /**
     * 接单时车辆纬度
     */
    private String receiveOrderCarLatitude;

    /**
     * 接单时间，派单成功时间
     */
    private LocalDateTime receiveOrderTime;

    /**
     * 机动车驾驶证号
     */
    private String licenseId;

    /**
     * 车辆号牌
     */
    private String vehicleNo;

    /**
     * 司机去接乘客出发时间
     */
    private LocalDateTime toPickUpPassengerTime;

    /**
     * 去接乘客时，司机的经度
     */
    private String toPickUpPassengerLongitude;

    /**
     * 去接乘客时，司机的纬度
     */
    private String toPickUpPassengerLatitude;

    /**
     * 去接乘客时，司机的地点
     */
    private String toPickUpPassengerAddress;

    /**
     * 司机到达上车点时间
     */
    private LocalDateTime driverArrivedDepartureTime;

    /**
     * 接到乘客，乘客上车时间
     */
    private LocalDateTime pickUpPassengerTime;

    /**
     * 接到乘客，乘客上车经度
     */
    private String pickUpPassengerLongitude;

    /**
     * 接到乘客，乘客上车纬度
     */
    private String pickUpPassengerLatitude;

    /**
     * 乘客下车时间
     */
    private LocalDateTime passengerGetoffTime;

    /**
     * 乘客下车经度
     */
    private String passengerGetoffLongitude;

    /**
     * 乘客下车纬度
     */
    private String passengerGetoffLatitude;

    /**
     * 订单撤销时间
     */
    private LocalDateTime cancelTime;

    /**
     * 撤销发起者：1:乘客	2:驾驶员	3:平台公司
     */
    private Integer cancelOperator;

    /**
     * 撤销类型代码
     * 1:乘客提前撤销
     * 2:驾驶员提前撤销
     * 3:平台公司撤销
     * 4:乘客违约撤销
     * 5:驾驶员违约撤销
     */
    private Integer cancelTypeCode;

    /**
     * 载客里程（米）
     */
    private Long driveMile;

    /**
     * 载客时间(分)
     */
    private Long driveTime;

    /**
     * 订单状态
     * 0:订单创建
     * 1:订单开始
     * 2:司机接单
     * 3:去接乘客
     * 4:司机到达乘客起点
     * 5:乘客上车，司机开始行程
     * 6:到达目的地，行程结束，未支付
     * 7:发起收款
     * 8:支付完成
     * 9:订单取消
     */
    private Integer orderStatus;

    /**
     * 价格
     */
    private Double price;

}
