package com.zjud.service;

import com.zjud.model.dto.device.order.AddDeviceOrderRequest;
import com.zjud.model.dto.device.order.UpdateDeviceOrderByUserRequest;
import com.zjud.model.dto.device.order.UpdateDeviceOrderRequest;
import com.zjud.model.entity.DeviceOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.model.vo.DeviceOrderVO;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【device_order(设备预约表)】的数据库操作Service
* @createDate 2023-08-31 14:31:48
*/
public interface DeviceOrderService extends IService<DeviceOrder> {

    /**
     * 移除预约
     * @param id
     * @return
     */
    Response<Boolean> removeOrder(Long id);

    /**
     * 添加预约
     * @param addDeviceOrderRequest
     * @return
     */
    Response<Boolean> addOrder(AddDeviceOrderRequest addDeviceOrderRequest);

    /**
     * 更新预约
     * @param updateDeviceOrderRequest
     * @return
     */
    Response<Boolean> updateOrder(UpdateDeviceOrderRequest updateDeviceOrderRequest);

    /**
     * 获取预约列表
     * @return
     */
    Response<List<DeviceOrderVO>> getOrderList();

    /**
     * 修改预约信息(用户)
     * @param updateDeviceOrderByUserRequest
     * @return
     */
    Response<Boolean> updateOrderByUser(UpdateDeviceOrderByUserRequest updateDeviceOrderByUserRequest);

    /**
     * 获取当前登录用户预约
     * @return
     */
    Response<List<DeviceOrderVO>> myOrders();
}
